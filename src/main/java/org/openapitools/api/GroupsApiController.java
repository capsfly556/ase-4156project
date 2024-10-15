package org.openapitools.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.annotation.Generated;
import javax.validation.Valid;
import org.openapitools.model.Group;
import org.openapitools.model.GroupOrder;
import org.openapitools.service.GroupOrderService;
import org.openapitools.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

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
          value = "/groups/getAllGroups",
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
    groupService.addGroup(group);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }



  @Override
  @DeleteMapping(value = "/groups/{groupId}/orders/{orderId}")
  public ResponseEntity<Void> groupsGroupIdOrdersOrderIdDelete(
          @PathVariable("groupId")
          UUID groupId,
          @PathVariable("orderId")
          UUID orderId){
    Boolean deleteSuccess=groupService.deleteGroupOrder(groupId,orderId);
    if (!deleteSuccess){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @Override
  @GetMapping(
          value = "/groups/{groupId}/orders",
          produces = {"application/json"})
  public ResponseEntity<List<GroupOrder>> groupsGroupIdOrdersGet(
          @PathVariable("groupId")
          UUID groupId){
    List<GroupOrder> groupOrderList=groupService.getGroupOrdersByGroupId(groupId);
    if (groupOrderList==null||groupOrderList.isEmpty()){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(groupOrderList,HttpStatus.OK);
  }


  @Override
  @GetMapping(
          value = "/groups/{groupId}/orders/{orderId}",
          produces = {"application/json"})
  public ResponseEntity<GroupOrder> groupsGroupIdOrdersOrderIdGet(
          @PathVariable("groupId")
          UUID groupId,
          @PathVariable("orderId")
          UUID orderId){
    if (!groupService.hasGroupOrder(groupId, orderId) ) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(groupOrderService.getGroupOrderById(orderId),
            HttpStatus.OK);
  }


  @Override
  @PutMapping(
          value = "/groups/{groupId}/orders/{orderId}",
          consumes = {"application/json"})
  public ResponseEntity<Void> groupsGroupIdOrdersOrderIdPut(
          @PathVariable("groupId")
          UUID groupId,
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
  @PostMapping(
          value = "/groups/{groupId}/orders",
          consumes = {"application/json"})
  public ResponseEntity<Void> groupsGroupIdOrdersPost(
          @Parameter(
                  name = "groupId",
                  description = "The unique identifier of the group.",
                  required = true,
                  in = ParameterIn.PATH)
          @PathVariable("groupId")
          UUID groupId,
          @Parameter(name = "GroupOrder", description = "", required = true) @Valid @RequestBody
          GroupOrder groupOrder){
    boolean success=groupService.addGroupOrder(groupId,groupOrder);
    if(!success){
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
