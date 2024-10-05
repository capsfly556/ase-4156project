package org.openapitools.service;

import org.openapitools.repository.ParticipantRepository;
import org.openapitools.model.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository repository;

    public Participant addParticipant(Participant participant) {
        return repository.save(participant);
    }
}
