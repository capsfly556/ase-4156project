package org.openapitools.service;

import org.openapitools.model.ParticipantOrder;
import org.openapitools.repository.ParticipantsOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParticipantsOrdersService {

  private final ParticipantsOrdersRepository repository;

  @Autowired
  public ParticipantsOrdersService(ParticipantsOrdersRepository repository) {
    this.repository = repository;
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

  public ParticipantOrder updateParticipantOrder(UUID participantID, UUID participantOrderID, ParticipantOrder participantOrder) {
    if (!repository.existsById(participantOrderID)) {
        throw new RuntimeException("Participant order not found");
    }
    participantOrder.setParticipantOrderID(participantOrderID);
    return repository.save(participantOrder);
  }

  public void createParticipantOrder(UUID participantID, ParticipantOrder participantOrder) {
    repository.save(participantOrder);
  }
}
