package org.openapitools.service;

import org.openapitools.repository.GroupsApiRepository;
import org.openapitools.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupsApiService {

    @Autowired
    private GroupsApiRepository repository;

    public Group addFoodProvider(Group group) {
        return repository.save(group);
    }
}
