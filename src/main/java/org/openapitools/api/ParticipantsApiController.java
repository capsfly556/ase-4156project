package org.openapitools.api;

import org.openapitools.model.Participant;
import org.openapitools.model.ParticipantOrder;

import org.openapitools.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.annotation.Generated;

@Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2024-10-02T19:11:02.971027-04:00[America/Toronto]",
    comments = "Generator version: 7.8.0")
@Controller
@RequestMapping("${openapi.groupGrub.base-path:}")
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

  @Override
  public ResponseEntity<Void> participantsPost(@Valid @RequestBody Participant participant) {
    try {
      participantService.addParticipant(participant);
      return new ResponseEntity<>(HttpStatus.CREATED);
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

  @DeleteMapping(value = "/participants/{participantID}")
  public ResponseEntity<Void> participantsParticipantIDDelete(@PathVariable("participantID") String participantID) {
    boolean isDeleted = participantService.deleteParticipant(UUID.fromString(participantID));

    if (isDeleted) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping(value = "/participants/{participantID}", produces = {"application/json"})
  public ResponseEntity<Participant> participantsParticipantIDGet(@PathVariable("participantID") String participantID) {
      Optional<Participant> participant = participantService.getParticipantById(UUID.fromString(participantID));

      if (participant.isPresent()) {
        return new ResponseEntity<>(participant.get(), HttpStatus.OK);
      } else {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
  }

  @PutMapping(value = "/participants/{participantID}", consumes = {"application/json"})
  public ResponseEntity<Void> participantsParticipantIDPut(@PathVariable("participantID") String participantID, @Valid @RequestBody Participant participant) {
    try {
        Participant updatedParticipant = participantService.updateParticipant(UUID.fromString(participantID), participant);
        return new ResponseEntity<>(HttpStatus.OK);
    } catch (RuntimeException e) {
        if (e.getMessage().equals("Participant not found")) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }
}