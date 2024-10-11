package org.openapitools.api;

import org.openapitools.model.Participant;
import org.openapitools.model.ParticipantOrder;
import org.openapitools.service.ParticipantsOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Generated;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.Optional;

@Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2024-10-02T19:11:02.971027-04:00[America/Toronto]",
    comments = "Generator version: 7.8.0")
@RestController
@RequestMapping("${openapi.groupGrub.base-path:}/participants")
public class ParticipantsOrdersApiController implements ParticipantsOrdersApi {

    private final ParticipantsOrdersService participantsOrdersService;

    @Autowired
    public ParticipantsOrdersApiController(ParticipantsOrdersService participantsOrdersService) {
      this.participantsOrdersService = participantsOrdersService;
    }

    @Override
    @GetMapping("/participants/{participantID}/orders")
    public ResponseEntity<List<ParticipantOrder>> participantsParticipantIDOrdersGet(
      @PathVariable("participantID") String participantID) {
      List<ParticipantOrder> orders = participantsOrdersService.getParticipantOrders(UUID.fromString(participantID));
      if (orders.isEmpty()) {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/participants/{participantID}/orders/{participantOrderID}")
    public ResponseEntity<Void> participantsParticipantIDOrdersParticipantOrderIDDelete(
      @PathVariable("participantID") String participantID,
      @PathVariable("participantOrderID") String participantOrderID) {
      boolean deleted = participantsOrdersService.deleteParticipantOrder(UUID.fromString(participantID), UUID.fromString(participantOrderID));
      if (deleted) {
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      } else {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }

    @Override
    @GetMapping("/participants/{participantID}/orders/{participantOrderID}")
    public ResponseEntity<ParticipantOrder> participantsParticipantIDOrdersParticipantOrderIDGet(
      @PathVariable("participantID") String participantID,
      @PathVariable("participantOrderID") String participantOrderID) {
      Optional<ParticipantOrder> order = participantsOrdersService.getParticipantOrder(UUID.fromString(participantID), UUID.fromString(participantOrderID));
      if (order.isPresent()) {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(order.get(), HttpStatus.OK);
    }

    @Override
    @PutMapping("/participants/{participantID}/orders/{participantOrderID}")
    public ResponseEntity<ParticipantOrder> participantsParticipantIDOrdersParticipantOrderIDPut(
      @PathVariable("participantID") String participantID,
      @PathVariable("participantOrderID") String participantOrderID,
      @Valid @RequestBody ParticipantOrder participantOrder) {
      try {
        ParticipantOrder updatedParticipantOrder = participantsOrdersService.updateParticipantOrder(UUID.fromString(participantID), 
          UUID.fromString(participantOrderID), participantOrder);
        return new ResponseEntity<>(updatedParticipantOrder, HttpStatus.OK);
      } catch (RuntimeException e) {
          if (e.getMessage().equals("Participant order not found")) {
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
    }

    @Override
    @PostMapping("/participants/{participantID}/orders")
    public ResponseEntity<Void> participantsParticipantIDOrdersPost(
      @PathVariable("participantID") String participantID,
      @Valid @RequestBody ParticipantOrder participantOrder) {
      participantsOrdersService.createParticipantOrder(UUID.fromString(participantID), participantOrder);
      return new ResponseEntity<>(HttpStatus.CREATED);
    }
}