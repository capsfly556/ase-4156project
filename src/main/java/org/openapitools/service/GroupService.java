package org.openapitools.service;

import org.hibernate.criterion.Order;
import org.openapitools.repository.GroupRepository;
import org.openapitools.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GroupService {

  @Autowired private GroupRepository repository;

  public Group addGroup(Group group) {
    return repository.save(group);
  }

  public List<Group> getAllGroup(){//retrieve all group in the database
    return repository.findAll();
  }
  public Group getGroupById(UUID groupId){
    return repository.findById(groupId).orElse(null);
  }
  public void deleteGroupById(UUID groupId){
    repository.deleteById(groupId);
  }
  public void updateGroupById(UUID groupId,Group newGroup){
    Group group=repository.findById(groupId).orElse(null);
    if(group==null){
      return;
    }
    group.setName(newGroup.getName());
    group.setGroupOrderIDs(newGroup.getGroupOrderIDs());
    group.setAdministratorID(newGroup.getAdministratorID());
    group.setParticipantIDs(newGroup.getParticipantIDs());
  }
}
