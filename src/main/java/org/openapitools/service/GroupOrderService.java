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

  public boolean hasGroupOrder(UUID id){
    return !repository.findById(id).isEmpty();
  }



}
