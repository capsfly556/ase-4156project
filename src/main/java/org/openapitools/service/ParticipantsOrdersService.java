package org.openapitools.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.openapitools.model.Participant;
import org.openapitools.model.ParticipantOrder;
import org.openapitools.repository.ParticipantRepository;
import org.openapitools.repository.ParticipantsOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantsOrdersService {

  private final ParticipantRepository participantRepository;
  private final ParticipantsOrdersRepository repository;

  @Autowired
  public ParticipantsOrdersService(ParticipantsOrdersRepository repository, ParticipantRepository participantRepository) {
    this.repository = repository;
	this.participantRepository = participantRepository;
  }

  public List<ParticipantOrder> getParticipantOrders(UUID participantID) {
    return repository.findByParticipantId(participantID);
  }

  public Optional<ParticipantOrder> getParticipantOrder(UUID participantID, UUID participantOrderID) {
    return repository.findById(participantOrderID);
  }

  public boolean deleteParticipantOrder(UUID participantID, UUID participantOrderID) {
    Optional<ParticipantOrder> order = repository.findById(participantOrderID);
    if (order.isPresent()) {
      repository.delete(order.get());
        return true;
    }
    return false;
  }

  public ParticipantOrder updateParticipantOrder(UUID participantID, UUID participantOrderID, ParticipantOrder updatedOrder) {
    Optional<ParticipantOrder> existingOrderOpt = repository.findById(participantOrderID);
    if (!existingOrderOpt.isPresent()) {
        throw new RuntimeException("Participant order not found");
    }
    
    Optional<Participant> participantOpt = participantRepository.findById(participantID);
    if (!participantOpt.isPresent()) {
        throw new RuntimeException("Participant not found");
    }

    ParticipantOrder existingOrder = existingOrderOpt.get();
    Participant participant = participantOpt.get();
    
    if (existingOrder.getParticipant() == null) {
        existingOrder.setParticipant(participant);
    }

    existingOrder.setComments(updatedOrder.getComments());
    existingOrder.setMenuItemIDs(updatedOrder.getMenuItemIDs());
    
    return repository.save(existingOrder);
}


public void createParticipantOrder(UUID participantID, ParticipantOrder participantOrder) {
    Optional<Participant> participantOptional = participantRepository.findById(participantID);

    if (participantOptional.isPresent()) {
        participantOrder.setParticipant(participantOptional.get());
    } else {
        throw new RuntimeException("Participant not found with ID: " + participantID);
    }

    if (participantOrder.getParticipantOrderID() != null) {
        if (repository.existsById(participantOrder.getParticipantOrderID())) {
            throw new RuntimeException("ParticipantOrder with ID: " 
                + participantOrder.getParticipantOrderID() + " already exists.");
        }
    } else {
        participantOrder.setParticipantOrderID(UUID.randomUUID());
    }

    repository.save(participantOrder);
}

}
