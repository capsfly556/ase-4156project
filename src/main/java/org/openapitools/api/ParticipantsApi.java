/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.8.0).
 * https://openapi-generator.tech Do not edit the class manually.
 */
package org.openapitools.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.annotation.Generated;
import javax.validation.Valid;
import org.openapitools.model.Participant;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

@Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2024-10-05T01:59:00.934263-04:00[America/Toronto]",
    comments = "Generator version: 7.8.0")
@Validated
@Tag(name = "participants", description = "the participants API")
public interface ParticipantsApi {

  default Optional<NativeWebRequest> getRequest() {
    return Optional.empty();
  }

  /**
   * GET /participants : Retrieve all participants registered in the service.
   *
   * @return Successfully retrieved participants. (status code 200) or No participants found.
   *     (status code 404)
   */
  @Operation(
      operationId = "participantsGet",
      summary = "Retrieve all participants registered in the service.",
      responses = {
        @ApiResponse(
            responseCode = "200",
            description = "Successfully retrieved participants.",
            content = {
              @Content(
                  mediaType = "application/json",
                  array = @ArraySchema(schema = @Schema(implementation = Participant.class)))
            }),
        @ApiResponse(responseCode = "404", description = "No participants found.")
      })
  @RequestMapping(
      method = RequestMethod.GET,
      value = "/participants",
      produces = {"application/json"})
  default ResponseEntity<List<Participant>> participantsGet(@RequestParam("participantsOrderIdFilter") Optional<UUID> participantsOrderIdFilter) {

    getRequest()
        .ifPresent(
            request -> {
              for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                  String exampleString =
                      "[ { \"participantID\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"participantOrderIDs\" : [ \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" ], \"name\" : \"name\" }, { \"participantID\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"participantOrderIDs\" : [ \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" ], \"name\" : \"name\" } ]";
                  ApiUtil.setExampleResponse(request, "application/json", exampleString);
                  break;
                }
              }
            });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

  /**
   * DELETE /participants/{participantID} : Delete a participant.
   *
   * @param participantID The unique identifier of the participant. (required)
   * @return Participant deleted successfully. (status code 204) or Participant not found. (status
   *     code 404)
   */
  @Operation(
      operationId = "participantsParticipantIDDelete",
      summary = "Delete a participant.",
      responses = {
        @ApiResponse(responseCode = "204", description = "Participant deleted successfully."),
        @ApiResponse(responseCode = "404", description = "Participant not found.")
      })
  @RequestMapping(method = RequestMethod.DELETE, value = "/participants/{participantID}")
  default ResponseEntity<Participant> participantsParticipantIDDelete(
      @Parameter(
              name = "participantID",
              description = "The unique identifier of the participant.",
              required = true,
              in = ParameterIn.PATH)
          @PathVariable("participantID")
          String participantID) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

  /**
   * GET /participants/{participantID} : Retrieve details of a participant by participantID.
   *
   * @param participantID The unique identifier of the participant. (required)
   * @return Participant details retrieved successfully. (status code 200) or Participant not found.
   *     (status code 404)
   */
  @Operation(
      operationId = "participantsParticipantIDGet",
      summary = "Retrieve details of a participant by participantID.",
      responses = {
        @ApiResponse(
            responseCode = "200",
            description = "Participant details retrieved successfully.",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Participant.class))
            }),
        @ApiResponse(responseCode = "404", description = "Participant not found.")
      })
  @RequestMapping(
      method = RequestMethod.GET,
      value = "/participants/{participantID}",
      produces = {"application/json"})
  default ResponseEntity<Participant> participantsParticipantIDGet(
      @Parameter(
              name = "participantID",
              description = "The unique identifier of the participant.",
              required = true,
              in = ParameterIn.PATH)
          @PathVariable("participantID")
          String participantID) {
    getRequest()
        .ifPresent(
            request -> {
              for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                  String exampleString =
                      "{ \"participantID\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"participantOrderIDs\" : [ \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" ], \"name\" : \"name\" }";
                  ApiUtil.setExampleResponse(request, "application/json", exampleString);
                  break;
                }
              }
            });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

  /**
   * PUT /participants/{participantID} : Update a participant's details.
   *
   * @param participantID The unique identifier of the participant. (required)
   * @param participant (required)
   * @return Participant updated successfully. (status code 200) or Failed to update participant.
   *     (status code 400) or Participant not found. (status code 404)
   */
  @Operation(
      operationId = "participantsParticipantIDPut",
      summary = "Update a participant's details.",
      responses = {
        @ApiResponse(responseCode = "200", description = "Participant updated successfully."),
        @ApiResponse(responseCode = "400", description = "Failed to update participant."),
        @ApiResponse(responseCode = "404", description = "Participant not found.")
      })
  @RequestMapping(
      method = RequestMethod.PUT,
      value = "/participants/{participantID}",
      consumes = {"application/json"})
  default ResponseEntity<Participant> participantsParticipantIDPut(
      @Parameter(
              name = "participantID",
              description = "The unique identifier of the participant.",
              required = true,
              in = ParameterIn.PATH)
          @PathVariable("participantID")
          String participantID,
      @Parameter(name = "Participant", description = "", required = true) @Valid @RequestBody
          Participant participant) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

  /**
   * POST /participants : Add a new participant.
   *
   * @param participant (required)
   * @return Participant added successfully. (status code 201) or Failed to add participant.
   *     (status code 400)
   */
  @Operation(
      operationId = "participantsPost",
      summary = "Add a new participant.",
      responses = {
        @ApiResponse(responseCode = "201", description = "Participant added successfully."),
        @ApiResponse(responseCode = "400", description = "Failed to add participant.")
      })
  @RequestMapping(
      method = RequestMethod.POST,
      value = "/participants",
      consumes = {"application/json"})
  default ResponseEntity<Participant> participantsPost(
      @Parameter(name = "Participant", description = "", required = true) @Valid @RequestBody
          Participant participant) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }
}
