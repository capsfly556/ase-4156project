package org.openapitools.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.openapitools.model.Group;

import org.openapitools.model.GroupOrderResponse;
import org.openapitools.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
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

  @Autowired
  public GroupsApiController(NativeWebRequest request, GroupService groupService) {
    this.request = request;
    this.groupService = groupService;
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

}
