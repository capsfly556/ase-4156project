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

  public GroupOrder getGroupOrderById(UUID id) {
    return repository.findById(id).orElse(null);
  }

  public boolean hasGroupOrder(UUID id) {
    return !repository.findById(id).isEmpty();
  }

  public boolean updateGroupOrder(UUID id, GroupOrder newOrder) {
    GroupOrder order = getGroupOrderById(id);
    if (order == null || newOrder == null) {
      return false;
    }

    order.setParticipantOrderIDs(newOrder.getParticipantOrderIDs());
    order.setStatus(newOrder.getStatus());
    order.setFoodProviderID(newOrder.getFoodProviderID());
    order.setMenuItemCounts(newOrder.getMenuItemCounts());
    order.setDesiredPickupTimeframe(newOrder.getDesiredPickupTimeframe());

    repository.save(order);
    return true;
  }

  public boolean createGroupOrder(GroupOrder order){
    order.fillFields();
    repository.save(order);
    return true;
  }

  public boolean createGroupOrder(UUID id){
    GroupOrder order=new GroupOrder();
    order.fillFields();
    order.setGroupOrderID(id);
    repository.save(order);
    return true;
  }
}
