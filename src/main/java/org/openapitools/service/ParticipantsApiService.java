package org.openapitools.service;

import org.openapitools.repository.ParticipantsApiRepository;
import org.openapitools.model.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantsApiService {

    @Autowired
    private ParticipantsApiRepository repository;

    public Participant addFoodProvider(Participant participant) {
        return repository.save(participant);
    }
}
