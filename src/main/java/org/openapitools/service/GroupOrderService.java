package org.openapitools.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.openapitools.model.Group;
import org.openapitools.model.GroupOrder;
import org.openapitools.repository.GroupOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupOrderService {
  @Autowired private GroupOrderRepository repository;
  @Autowired private GroupService groupService;

  public GroupOrder getGroupOrderById(UUID id) {
    return repository.findById(id).orElse(null);
  }

  public List<GroupOrder> getGroupOrdersByGroupId(UUID id) {
    Group group = groupService.getGroupById(id);
    if (group == null) {
      return null;
    }

    List<UUID> groupOrderIds = group.getGroupOrderIDs();
    if (groupOrderIds.isEmpty()) {
      return null;
    }

    List<GroupOrder> groupOrderList = new ArrayList<GroupOrder>();
    for (UUID uuid : groupOrderIds) {
      GroupOrder groupOrder = getGroupOrderById(uuid);
      if (groupOrder == null) {
        continue;
      }
      groupOrderList.add(groupOrder);
    }
    return groupOrderList;
  }
}
