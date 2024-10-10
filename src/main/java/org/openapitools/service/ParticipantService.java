package org.openapitools.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.openapitools.repository.ParticipantRepository;
import org.openapitools.model.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ParticipantService {

  @Autowired 
  private ParticipantRepository repository;

  public Participant addParticipant(Participant participant) {
    return repository.save(participant);
  }

  public List<Participant> getAllParticipants() {
    return repository.findAll();
  }

  public Optional<Participant> getParticipantById(UUID participantID) {
    return repository.findById(participantID);
  }

  @Transactional
  public Participant updateParticipant(UUID participantID, Participant updatedParticipant) {
    return repository.findById(participantID)
        .map(participant -> {
          participant.setName(updatedParticipant.getName());
          participant.setParticipantOrderIDs(updatedParticipant.getParticipantOrderIDs());
          return repository.save(participant);
        })
        .orElseThrow(() -> new RuntimeException("Participant not found"));
  }

  public void deleteParticipant(UUID participantID) {
    repository.deleteById(participantID);
  }
}
