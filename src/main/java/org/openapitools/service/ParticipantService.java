package org.openapitools.service;

import java.util.ArrayList;
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

  @Transactional
  public Participant updateParticipant(UUID participantID, Participant updatedParticipant) {
	System.out.println("Updating participant with ID: " + participantID);
    return repository.findById(participantID)
        .map(participant -> {
          participant.setName(updatedParticipant.getName());
          participant.setParticipantOrderIDs(updatedParticipant.getParticipantOrderIDs());
          return repository.save(participant);
        })
        .orElseThrow(() -> {
			System.out.println("Participant not found with ID: " + participantID);
			return new RuntimeException("Participant not found");
		});
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
