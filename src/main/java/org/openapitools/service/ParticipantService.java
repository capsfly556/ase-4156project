package org.openapitools.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.openapitools.repository.ParticipantRepository;
import org.openapitools.model.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantService {

  private final ParticipantRepository repository;

  @Autowired
  public ParticipantService(ParticipantRepository repository) {
    this.repository = repository;
  }

  public Participant addParticipant(Participant participant) {
    System.out.println("Adding participant: " + participant.getName());
    return repository.save(participant);
  }

  public List<Participant> getAllParticipants() {
    System.out.println("Getting all participants");
    return repository.findAll();
  }

  public Optional<Participant> getParticipantById(UUID participantID) {
    System.out.println("Getting participant with ID: " + participantID);
    return repository.findById(participantID);
  }

  public Participant updateParticipant(UUID participantID, Participant participant) {
    System.out.println("Updating participant with ID: " + participantID);
    if (!repository.existsById(participantID)) {
      throw new RuntimeException("Participant not found");
    }
    participant.setParticipantID(participantID);
    return repository.save(participant);
  }

  public boolean deleteParticipant(UUID participantID) {
    System.out.println("Deleting participant with ID: " + participantID);
    if (repository.existsById(participantID)) {
      repository.deleteById(participantID);
      return true;
    }
    return false;
  }
}
