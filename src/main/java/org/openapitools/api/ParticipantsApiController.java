package org.openapitools.api;

import org.openapitools.model.Participant;
import org.openapitools.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;


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
public class ParticipantsApiController implements ParticipantsApi {

  private final NativeWebRequest request;
  private final ParticipantService participantService;

  @Autowired
  public ParticipantsApiController(
      NativeWebRequest request, ParticipantService participantService) {
    this.request = request;
    this.participantService = participantService;
  }

  @Override
  public Optional<NativeWebRequest> getRequest() {
    return Optional.ofNullable(request);
  }
  @PostMapping(value = "/participants", produces = {"application/json"})
  public ResponseEntity<Participant> participantsPost(@Valid @RequestBody Participant participant) {
    try {
      Participant savedParticipant = participantService.addParticipant(participant);
      return new ResponseEntity<>(savedParticipant, HttpStatus.CREATED);
    } catch (Exception e) { 
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping(value = "/participants", produces = {"application/json"})
  public ResponseEntity<List<Participant>> participantsGet() {
      List<Participant> participants = participantService.getAllParticipants();
      if (participants.isEmpty()) {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(participants, HttpStatus.OK);
  }
  @DeleteMapping(value = "/participants/{participantID}", produces = {"application/json"})
  public ResponseEntity<Participant> participantsParticipantIDDelete(@PathVariable String participantID) {
    boolean deleted = participantService.deleteParticipantById(UUID.fromString(participantID));
    if (deleted) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping(value = "/participants/{participantID}", produces = {"application/json"})
  public ResponseEntity<Participant> participantsParticipantIDGet(@PathVariable String participantID) {
    Optional<Participant> participant = participantService.getParticipantById(UUID.fromString(participantID));
    if (participant.isPresent()) {
        return new ResponseEntity<>(participant.get(), HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping(value = "/participants/{participantID}", consumes = {"application/json"})
    public ResponseEntity<Participant> participantsParticipantIDPut(String participantID, @Valid @RequestBody Participant participant) {
      try {
        Participant updatedParticipant = participantService.updateParticipant(UUID.fromString(participantID), participant);
        return new ResponseEntity<>(updatedParticipant, HttpStatus.OK);
      } catch (RuntimeException e) {
          if (e.getMessage().equals("Participant not found")) {
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
    }
}