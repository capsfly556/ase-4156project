package org.openapitools.service;

import org.openapitools.repository.GroupRepository;
import org.openapitools.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

  @Autowired private GroupRepository repository;

  public Group addGroup(Group group) {
    return repository.save(group);
  }
}
