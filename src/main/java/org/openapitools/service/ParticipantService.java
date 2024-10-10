package org.openapitools.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.openapitools.repository.ParticipantRepository;
import org.openapitools.model.Participant;
import org.openapitools.model.ParticipantOrder;
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

  public List<ParticipantOrder> getOrdersByParticipantId(UUID participantID) {
    System.out.println("Getting all participant orders for participant ID: " + participantID);
    return repository.findOrdersByParticipantID(participantID);
  }

	public boolean deleteOrderByParticipantIdAndOrderId(UUID participantID, UUID participantOrderID) {
		boolean orderExists = repository.existsByParticipantIDAndOrderID(participantID, participantOrderID);
        
    if (!orderExists) {
        System.err.println("Order with ID " + participantOrderID + " for participant " + participantID + " does not exist.");
        return false;
    }
    
    repository.unlinkOrderFromParticipant(participantID, participantOrderID);
    repository.deleteOrderByParticipantIDAndOrderID(participantID, participantOrderID);
    return true;
	}

  public Optional<ParticipantOrder> getOrderByParticipantIdAndOrderId(UUID participantID, UUID participantOrderID) {
    System.out.println("Getting participant order with participant ID: " + participantID + " and order ID: " + participantOrderID);
    return repository.findOrderByParticipantIDAndParticipantOrderID(participantID, participantOrderID);
  }

  public boolean orderExists(UUID participantID, UUID participantOrderID) {
    return repository.existsByParticipantIDAndOrderID(participantID, participantOrderID);
  }

  public void createParticipantOrder(UUID participantID, ParticipantOrder participantOrder) {
    UUID participantOrderID = UUID.randomUUID();
    participantOrder.setParticipantOrderID(participantOrderID);

    repository.saveParticipantOrder(participantOrder.getParticipantOrderID(), participantOrder.getComments());
  
    for (Map.Entry<UUID, Integer> entry : participantOrder.getMenuItemIDs().entrySet()) {
        UUID menuItemID = entry.getKey();
        Integer count = entry.getValue();
        repository.linkMenuItemToOrder(participantOrderID, menuItemID, count);
    }
 }

public boolean updateParticipantOrder(UUID participantID, UUID participantOrderID, ParticipantOrder participantOrder) {
      Optional<ParticipantOrder> existingOrderOpt = repository.findOrderById(participantOrderID);
      
      // Check if the order exists
      if (!existingOrderOpt.isPresent()) {
          return false; // Order not found
      }
      
      ParticipantOrder existingOrder = existingOrderOpt.get();
      existingOrder.setComments(participantOrder.getComments()); // Update comments

      // Update menu item IDs (assuming menu item IDs are stored as a Map)
      existingOrder.setMenuItemIDs(participantOrder.getMenuItemIDs());

      // Persist the updated order
      participantOrderRepository.save(existingOrder); // Assuming save() works for updating existing records
      
      // Here, you may want to update your participant_order_menu_itemids table
      updateMenuItemLinks(existingOrder); // Method to handle linking menu items

      return true; // Update successful 
  }
}
