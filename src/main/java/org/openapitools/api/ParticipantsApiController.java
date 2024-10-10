package org.openapitools.api;

import org.openapitools.model.Participant;
import org.openapitools.model.ParticipantOrder;

import org.openapitools.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.enums.ParameterIn;

import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.List;
import java.util.Map;
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
  public ResponseEntity<Void> participantsParticipantIDDelete(String participantID) {
    boolean isDeleted = participantService.deleteParticipant(UUID.fromString(participantID));

    if (isDeleted) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping(value = "/{participantID}", produces = {"application/json"})
  public ResponseEntity<Participant> participantsParticipantIDGet(String participantID) {
      Optional<Participant> participant = participantService.getParticipantById(UUID.fromString(participantID));

      if (participant.isPresent()) {
        return new ResponseEntity<>(HttpStatus.OK);
      } else {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
  }

  @PutMapping(value = "/{participantID}", consumes = {"application/json"})
  public ResponseEntity<Void> participantsParticipantIDPut(String participantID, @Valid @RequestBody Participant participant) {
    try {
      Participant updatedParticipant = participantService.updateParticipant(UUID.fromString(participantID), participant);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (RuntimeException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

}
