package org.openapitools.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.openapitools.model.Group;

import org.openapitools.model.GroupOrder;
import org.openapitools.model.GroupOrderResponse;
import org.openapitools.service.GroupOrderService;
import org.openapitools.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.ResourcePropertiesPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
public class GroupsApiController implements GroupsApi {

  private final NativeWebRequest request;
  private final GroupService groupService;
  private final GroupOrderService groupOrderService;

  @Autowired
  public GroupsApiController(NativeWebRequest request, GroupService groupService,
                             GroupOrderService groupOrderService) {
    this.request = request;
    this.groupService = groupService;
    this.groupOrderService=groupOrderService;
  }

  @Override
  public Optional<NativeWebRequest> getRequest() {
    return Optional.ofNullable(request);
  }


  @Override
  @GetMapping(
          value = "/groups",
          produces = {"application/json"})
  public ResponseEntity<List<Group>> groupsGet(){
    List<Group>groupList=groupService.getAllGroup();
    if(groupList.isEmpty()){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(groupList,HttpStatus.OK);
  }

  @Override
  @DeleteMapping (value = "/groups/{groupId}")
  public ResponseEntity<Void> groupsGroupIdDelete(
          @PathVariable("groupId")
          UUID groupId){
    if(groupService.getGroupById(groupId)==null){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    groupService.deleteGroupById(groupId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @Override
  @GetMapping(
          value = "/groups/{groupId}",
          produces = {"application/json"})
  public ResponseEntity<Group> groupsGroupIdGet(@PathVariable("groupId") UUID groupId){
    Group group=groupService.getGroupById(groupId);
    if (group==null){
      return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(group,HttpStatus.OK);
  }

  @Override
  @PutMapping(
          value = "/groups/{groupId}",
          consumes = {"application/json"})
  public ResponseEntity<Void> groupsGroupIdPut(
          @PathVariable("groupId")
          UUID groupId,
          @Valid @RequestBody
          Group group){
    Group oldGroup=groupService.getGroupById(groupId);
    if (oldGroup==null){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    groupService.updateGroupById(groupId,group);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PostMapping(
          value = "/groups",
          consumes = {"application/json"})
  public ResponseEntity<Void> groupsPost(
          @Valid
          @RequestBody
          Group group){
    Group returnGroup=groupService.addGroup(group);
    if(group!=returnGroup){
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(HttpStatus.CREATED);
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
  @DeleteMapping(value = "/groups/{groupId}/orders/{orderId}")
  public ResponseEntity<Void> groupsGroupIdOrdersOrderIdDelete(
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
          UUID orderId){
    Boolean deleteSuccess=groupService.deleteGroupOrder(groupId,orderId);
    if (!deleteSuccess){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @Override

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
  @GetMapping(
          value = "/groups/{groupId}/orders",
          produces = {"application/json"})
  public ResponseEntity<List<GroupOrder>> groupsGroupIdOrdersGet(
          @Parameter(
                  name = "groupId",
                  description = "The unique identifier of the group.",
                  required = true,
                  in = ParameterIn.PATH)
          @PathVariable("groupId")
          UUID groupId){
    List<GroupOrder> groupOrderList=groupService.getGroupOrdersByGroupId(groupId);
    if (groupOrderList==null||groupOrderList.isEmpty()){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(groupOrderList,HttpStatus.OK);
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
  @GetMapping(
          value = "/groups/{groupId}/orders/{orderId}",
          produces = {"application/json"})
  public ResponseEntity<GroupOrder> groupsGroupIdOrdersOrderIdGet(
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
          UUID orderId){
    if (!groupService.hasGroupOrder(groupId, orderId) ) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(groupOrderService.getGroupOrderById(orderId),
            HttpStatus.OK);
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
  @PutMapping(
          value = "/groups/{groupId}/orders/{orderId}",
          consumes = {"application/json"})
  public ResponseEntity<Void> groupsGroupIdOrdersOrderIdPut(
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
          UUID orderId,
          @Parameter(name = "GroupOrder", description = "", required = true) @Valid @RequestBody
          GroupOrder groupOrder){
    if (!groupService.hasGroupOrder(groupId,orderId)){
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    if(!groupOrderService.updateGroupOrder(orderId,groupOrder)){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
