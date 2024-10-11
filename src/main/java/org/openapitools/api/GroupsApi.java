/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.8.0).
 * https://openapi-generator.tech Do not edit the class manually.
 */
package org.openapitools.api;

import org.openapitools.model.Group;
import org.openapitools.model.GroupOrder;
import org.openapitools.model.GroupOrderResponse;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import javax.annotation.Generated;

@Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2024-10-05T01:59:00.934263-04:00[America/Toronto]",
    comments = "Generator version: 7.8.0")
@Validated
@Tag(name = "groups", description = "the groups API")
public interface GroupsApi {

  default Optional<NativeWebRequest> getRequest() {
    return Optional.empty();
  }

  /**
   * GET /groups : Retrieve a list of all groups in the service.
   *
   * @return Successfully retrieved a list of all groups in the service. (status code 200) or No
   *     groups found in the service. (status code 404)
   */
  @Operation(
      operationId = "groupsGet",
      summary = "Retrieve a list of all groups in the service.",
      responses = {
        @ApiResponse(
            responseCode = "200",
            description = "Successfully retrieved a list of all groups in the service.",
            content = {
              @Content(
                  mediaType = "application/json",
                  array = @ArraySchema(schema = @Schema(implementation = Group.class)))
            }),
        @ApiResponse(responseCode = "404", description = "No groups found in the service.")
      })
  @RequestMapping(
      method = RequestMethod.GET,
      value = "/groups",
      produces = {"application/json"})
  default ResponseEntity<List<Group>> groupsGet() {

    getRequest()
        .ifPresent(
            request -> {
              for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                  String exampleString =
                      "[ { \"administratorID\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"groupOrderIDs\" : [ \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" ], \"groupID\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"name\" : \"name\", \"participantIDs\" : [ \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" ] }, { \"administratorID\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"groupOrderIDs\" : [ \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" ], \"groupID\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"name\" : \"name\", \"participantIDs\" : [ \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" ] } ]";
                  ApiUtil.setExampleResponse(request, "application/json", exampleString);
                  break;
                }
              }
            });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

  /**
   * DELETE /groups/{groupId} : Delete a group.
   *
   * @param groupId The unique identifier of the group. (required)
   * @return Group deleted successfully. (status code 204) or Group not found. (status code 404)
   */
  @Operation(
      operationId = "groupsGroupIdDelete",
      summary = "Delete a group.",
      responses = {
        @ApiResponse(responseCode = "204", description = "Group deleted successfully."),
        @ApiResponse(responseCode = "404", description = "Group not found.")
      })
  @RequestMapping(method = RequestMethod.DELETE, value = "/groups/{groupId}")
  default ResponseEntity<Void> groupsGroupIdDelete(
      @Parameter(
              name = "groupId",
              description = "The unique identifier of the group.",
              required = true,
              in = ParameterIn.PATH)
          @PathVariable("groupId")
      UUID groupId) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

  /**
   * GET /groups/{groupId} : Retrieve details of a specific group.
   *
   * @param groupId The unique identifier of the group. (required)
   * @return Group details retrieved successfully. (status code 200) or Group not found. (status
   *     code 404)
   */
  @Operation(
      operationId = "groupsGroupIdGet",
      summary = "Retrieve details of a specific group.",
      responses = {
        @ApiResponse(
            responseCode = "200",
            description = "Group details retrieved successfully.",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Group.class))
            }),
        @ApiResponse(responseCode = "404", description = "Group not found.")
      })
  @RequestMapping(
      method = RequestMethod.GET,
      value = "/groups/{groupId}",
      produces = {"application/json"})
  default ResponseEntity<Group> groupsGroupIdGet(
      @Parameter(
              name = "groupId",
              description = "The unique identifier of the group.",
              required = true,
              in = ParameterIn.PATH)
          @PathVariable("groupId")
          UUID groupId) {
    getRequest()
        .ifPresent(
            request -> {
              for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                  String exampleString =
                      "{ \"administratorID\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"groupOrderIDs\" : [ \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" ], \"groupID\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"name\" : \"name\", \"participantIDs\" : [ \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" ] }";
                  ApiUtil.setExampleResponse(request, "application/json", exampleString);
                  break;
                }
              }
            });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

  /**
   * GET /groups/{groupId}/orders : Retrieve all group orders for a specific group.
   *
   * @param groupId The unique identifier of the group. (required)
   * @return List of group orders retrieved successfully. (status code 200)
   */
  @Operation(
      operationId = "groupsGroupIdOrdersGet",
      summary = "Retrieve all group orders for a specific group.",
      responses = {
        @ApiResponse(
            responseCode = "200",
            description = "List of group orders retrieved successfully.",
            content = {
              @Content(
                  mediaType = "application/json",
                  array = @ArraySchema(schema = @Schema(implementation = GroupOrderResponse.class)))
            })
      })
  @RequestMapping(
      method = RequestMethod.GET,
      value = "/groups/{groupId}/orders",
      produces = {"application/json"})
  default ResponseEntity<List<GroupOrderResponse>> groupsGroupIdOrdersGet(
      @Parameter(
              name = "groupId",
              description = "The unique identifier of the group.",
              required = true,
              in = ParameterIn.PATH)
          @PathVariable("groupId")
          UUID groupId) {
    getRequest()
        .ifPresent(
            request -> {
              for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                  String exampleString =
                      "[ { \"participantOrderIDs\" : [ \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" ], \"groupOrderID\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"menuItemIDs\" : { \"key\" : 0 }, \"participantOrders\" : [ { \"menuItemIDs\" : { \"key\" : 6 }, \"comments\" : \"comments\", \"participantOrderID\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }, { \"menuItemIDs\" : { \"key\" : 6 }, \"comments\" : \"comments\", \"participantOrderID\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" } ], \"desiredPickupTimeframe\" : \"desiredPickupTimeframe\", \"foodProviderID\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"status\" : \"status\" }, { \"participantOrderIDs\" : [ \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" ], \"groupOrderID\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"menuItemIDs\" : { \"key\" : 0 }, \"participantOrders\" : [ { \"menuItemIDs\" : { \"key\" : 6 }, \"comments\" : \"comments\", \"participantOrderID\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }, { \"menuItemIDs\" : { \"key\" : 6 }, \"comments\" : \"comments\", \"participantOrderID\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" } ], \"desiredPickupTimeframe\" : \"desiredPickupTimeframe\", \"foodProviderID\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"status\" : \"status\" } ]";
                  ApiUtil.setExampleResponse(request, "application/json", exampleString);
                  break;
                }
              }
            });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

  /**
   * DELETE /groups/{groupId}/orders/{orderId} : Delete a group order.
   *
   * @param groupId The unique identifier of the group. (required)
   * @param orderId The unique identifier of the order. (required)
   * @return Group order deleted successfully. (status code 204) or Group order not found. (status
   *     code 404)
   */
  @Operation(
      operationId = "groupsGroupIdOrdersOrderIdDelete",
      summary = "Delete a group order.",
      responses = {
        @ApiResponse(responseCode = "204", description = "Group order deleted successfully."),
        @ApiResponse(responseCode = "404", description = "Group order not found.")
      })
  @RequestMapping(method = RequestMethod.DELETE, value = "/groups/{groupId}/orders/{orderId}")
  default ResponseEntity<Void> groupsGroupIdOrdersOrderIdDelete(
      @Parameter(
              name = "groupId",
              description = "The unique identifier of the group.",
              required = true,
              in = ParameterIn.PATH)
          @PathVariable("groupId")
          UUID groupId,
      @Parameter(
              name = "orderId",
              description = "The unique identifier of the order.",
              required = true,
              in = ParameterIn.PATH)
          @PathVariable("orderId")
          String orderId) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

  /**
   * GET /groups/{groupId}/orders/{orderId} : Retrieve details of a specific group order.
   *
   * @param groupId The unique identifier of the group. (required)
   * @param orderId The unique identifier of the order. (required)
   * @return Group order details retrieved successfully. (status code 200) or Group order not found.
   *     (status code 404)
   */
  @Operation(
      operationId = "groupsGroupIdOrdersOrderIdGet",
      summary = "Retrieve details of a specific group order.",
      responses = {
        @ApiResponse(
            responseCode = "200",
            description = "Group order details retrieved successfully.",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = GroupOrderResponse.class))
            }),
        @ApiResponse(responseCode = "404", description = "Group order not found.")
      })
  @RequestMapping(
      method = RequestMethod.GET,
      value = "/groups/{groupId}/orders/{orderId}",
      produces = {"application/json"})
  default ResponseEntity<GroupOrderResponse> groupsGroupIdOrdersOrderIdGet(
      @Parameter(
              name = "groupId",
              description = "The unique identifier of the group.",
              required = true,
              in = ParameterIn.PATH)
          @PathVariable("groupId")
          UUID groupId,
      @Parameter(
              name = "orderId",
              description = "The unique identifier of the order.",
              required = true,
              in = ParameterIn.PATH)
          @PathVariable("orderId")
          String orderId) {
    getRequest()
        .ifPresent(
            request -> {
              for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                  String exampleString =
                      "{ \"participantOrderIDs\" : [ \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" ], \"groupOrderID\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"menuItemIDs\" : { \"key\" : 0 }, \"participantOrders\" : [ { \"menuItemIDs\" : { \"key\" : 6 }, \"comments\" : \"comments\", \"participantOrderID\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }, { \"menuItemIDs\" : { \"key\" : 6 }, \"comments\" : \"comments\", \"participantOrderID\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" } ], \"desiredPickupTimeframe\" : \"desiredPickupTimeframe\", \"foodProviderID\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"status\" : \"status\" }";
                  ApiUtil.setExampleResponse(request, "application/json", exampleString);
                  break;
                }
              }
            });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

  /**
   * PUT /groups/{groupId}/orders/{orderId} : Update a group order.
   *
   * @param groupId The unique identifier of the group. (required)
   * @param orderId The unique identifier of the order. (required)
   * @param groupOrder (required)
   * @return Group order updated successfully. (status code 200) or Failed to update the group
   *     order. (status code 400)
   */
  @Operation(
      operationId = "groupsGroupIdOrdersOrderIdPut",
      summary = "Update a group order.",
      responses = {
        @ApiResponse(responseCode = "200", description = "Group order updated successfully."),
        @ApiResponse(responseCode = "400", description = "Failed to update the group order.")
      })
  @RequestMapping(
      method = RequestMethod.PUT,
      value = "/groups/{groupId}/orders/{orderId}",
      consumes = {"application/json"})
  default ResponseEntity<Void> groupsGroupIdOrdersOrderIdPut(
      @Parameter(
              name = "groupId",
              description = "The unique identifier of the group.",
              required = true,
              in = ParameterIn.PATH)
          @PathVariable("groupId")
          UUID groupId,
      @Parameter(
              name = "orderId",
              description = "The unique identifier of the order.",
              required = true,
              in = ParameterIn.PATH)
          @PathVariable("orderId")
          String orderId,
      @Parameter(name = "GroupOrder", description = "", required = true) @Valid @RequestBody
          GroupOrder groupOrder) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

  /**
   * POST /groups/{groupId}/orders : Create a new group order.
   *
   * @param groupId The unique identifier of the group. (required)
   * @param groupOrder (required)
   * @return Group order created successfully. (status code 201)
   */
  @Operation(
      operationId = "groupsGroupIdOrdersPost",
      summary = "Create a new group order.",
      responses = {
        @ApiResponse(responseCode = "201", description = "Group order created successfully.")
      })
  @RequestMapping(
      method = RequestMethod.POST,
      value = "/groups/{groupId}/orders",
      consumes = {"application/json"})
  default ResponseEntity<Void> groupsGroupIdOrdersPost(
      @Parameter(
              name = "groupId",
              description = "The unique identifier of the group.",
              required = true,
              in = ParameterIn.PATH)
          @PathVariable("groupId")
          UUID groupId,
      @Parameter(name = "GroupOrder", description = "", required = true) @Valid @RequestBody
          GroupOrder groupOrder) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

  /**
   * PUT /groups/{groupId} : Update a group&#39;s details.
   *
   * @param groupId The unique identifier of the group. (required)
   * @param group (required)
   * @return Group updated successfully. (status code 200) or Group not found. (status code 404)
   */
  @Operation(
      operationId = "groupsGroupIdPut",
      summary = "Update a group's details.",
      responses = {
        @ApiResponse(responseCode = "200", description = "Group updated successfully."),
        @ApiResponse(responseCode = "404", description = "Group not found.")
      })
  @RequestMapping(
      method = RequestMethod.PUT,
      value = "/groups/{groupId}",
      consumes = {"application/json"})
  default ResponseEntity<Void> groupsGroupIdPut(
      @Parameter(
              name = "groupId",
              description = "The unique identifier of the group.",
              required = true,
              in = ParameterIn.PATH)
          @PathVariable("groupId")
          UUID groupId,
      @Parameter(name = "Group", description = "", required = true) @Valid @RequestBody
          Group group) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

  /**
   * POST /groups : Add a new group to the service.
   *
   * @param group Group object to add, must specify group name, participant IDs, groupOrder IDs, and
   *     administrator ID. (required)
   * @return Successfully added a new group. (status code 201) or Failed to add a new group. (status
   *     code 400)
   */
  @Operation(
      operationId = "groupsPost",
      summary = "Add a new group to the service.",
      responses = {
        @ApiResponse(responseCode = "201", description = "Successfully added a new group."),
        @ApiResponse(responseCode = "400", description = "Failed to add a new group.")
      })
  @RequestMapping(
      method = RequestMethod.POST,
      value = "/groups",
      consumes = {"application/json"})
  default ResponseEntity<Void> groupsPost(
      @Parameter(
              name = "Group",
              description =
                  "Group object to add, must specify group name, participant IDs, groupOrder IDs, and administrator ID.",
              required = true)
          @Valid
          @RequestBody
          Group group) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }
}
