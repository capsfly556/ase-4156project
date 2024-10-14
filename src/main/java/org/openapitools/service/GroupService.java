package org.openapitools.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.openapitools.model.Group;
import org.openapitools.model.GroupOrder;
import org.openapitools.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

  @Autowired private GroupRepository groupRepository;
  @Autowired private GroupOrderService groupOrderService;

  public Group addGroup(Group group) {
    List<UUID> groupOrders=group.getGroupOrderIDs();

    return groupRepository.save(group);
  }

  public List<Group> getAllGroup(){//retrieve all group in the database
    return groupRepository.findAll();
  }
  public Group getGroupById(UUID groupId){
    return groupRepository.findById(groupId).orElse(null);
  }
  public void deleteGroupById(UUID groupId){
    groupRepository.deleteById(groupId);
  }
  public void updateGroupById(UUID groupId,Group newGroup){
    Group group= groupRepository.findById(groupId).orElse(null);
    if(group==null){
      return;
    }
    group.setName(newGroup.getName());
    group.setGroupOrderIDs(newGroup.getGroupOrderIDs());
    group.setAdministratorID(newGroup.getAdministratorID());
    group.setParticipantIDs(newGroup.getParticipantIDs());
    groupRepository.save(group);
  }
  public Boolean groupHasOrderId(Group group, UUID orderId){
    List<UUID> groupOrderIds = group.getGroupOrderIDs();
    if (groupOrderIds == null) {
      return false;
    }
    for (UUID uuid : groupOrderIds) {
      if (uuid.equals(orderId)) {
        return true;
      }
    }
    return false;
  }

  public Boolean deleteGroupOrder(UUID groupId, UUID orderId){
    Optional<Group> group = groupRepository.findById(groupId);
    if (group.isEmpty()) {
      return false;
    }
    if (!groupHasOrderId(group.get(), orderId)) {
      return false;
    }
    List<UUID> groupOrderIds = group.get().getGroupOrderIDs();
    groupOrderIds.remove(orderId);
    group.get().setGroupOrderIDs(groupOrderIds);
    groupRepository.save(group.get());
    return true;
  }

  public boolean hasGroupOrder(UUID groupId, UUID orderId) {
    Group group = getGroupById(groupId);
    if (group == null) {
      return false;
    }
    List<UUID> orderIdList = group.getGroupOrderIDs();
    return orderIdList.contains(orderId);
  }

  public List<GroupOrder> getGroupOrdersByGroupId(UUID id) {
    Group group = getGroupById(id);
    if (group == null) {
      return null;
    }

    List<UUID> groupOrderIds = group.getGroupOrderIDs();
    if (groupOrderIds==null||groupOrderIds.isEmpty()) {
      return null;
    }

    List<GroupOrder> groupOrderList = new ArrayList<GroupOrder>();
    for (UUID groupOrderId : groupOrderIds) {
      GroupOrder groupOrder =groupOrderService.getGroupOrderById(groupOrderId);
      if (groupOrder == null) {
        continue;
      }
      groupOrderList.add(groupOrder);
    }
    return groupOrderList;
  }
  public boolean addGroupOrder(UUID groupId,GroupOrder order){
    Group group=getGroupById(groupId);
    if (group==null){
      return false;
    }
    order.fillFields();
    List<UUID> groupOrders=group.getGroupOrderIDs();
    if (!groupOrders.contains(order.getGroupOrderID())) {
      groupOrders.add(order.getGroupOrderID());
    }
    group.setGroupOrderIDs(groupOrders);
    groupOrderService.createGroupOrder(order);
    return true;
  }
}
