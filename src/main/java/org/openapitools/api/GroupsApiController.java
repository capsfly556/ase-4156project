package org.openapitools.api;

import org.openapitools.model.Group;

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
  public ResponseEntity<Void> groupsPost(@Valid @RequestBody Group group) {
    groupService.addGroup(group);
    return new ResponseEntity<>(HttpStatus.CREATED);
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
}
