package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Group
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-02T19:11:02.971027-04:00[America/Toronto]", comments = "Generator version: 7.8.0")
public class Group {

  private String groupID;

  private String name;

  @Valid
  private List<String> participantIDs = new ArrayList<>();

  @Valid
  private List<String> groupOrderIDs = new ArrayList<>();

  private String administratorID;

  public Group groupID(String groupID) {
    this.groupID = groupID;
    return this;
  }

  /**
   * Get groupID
   * @return groupID
   */
  
  @Schema(name = "groupID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("groupID")
  public String getGroupID() {
    return groupID;
  }

  public void setGroupID(String groupID) {
    this.groupID = groupID;
  }

  public Group name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   */
  
  @Schema(name = "name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Group participantIDs(List<String> participantIDs) {
    this.participantIDs = participantIDs;
    return this;
  }

  public Group addParticipantIDsItem(String participantIDsItem) {
    if (this.participantIDs == null) {
      this.participantIDs = new ArrayList<>();
    }
    this.participantIDs.add(participantIDsItem);
    return this;
  }

  /**
   * Get participantIDs
   * @return participantIDs
   */
  
  @Schema(name = "participantIDs", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("participantIDs")
  public List<String> getParticipantIDs() {
    return participantIDs;
  }

  public void setParticipantIDs(List<String> participantIDs) {
    this.participantIDs = participantIDs;
  }

  public Group groupOrderIDs(List<String> groupOrderIDs) {
    this.groupOrderIDs = groupOrderIDs;
    return this;
  }

  public Group addGroupOrderIDsItem(String groupOrderIDsItem) {
    if (this.groupOrderIDs == null) {
      this.groupOrderIDs = new ArrayList<>();
    }
    this.groupOrderIDs.add(groupOrderIDsItem);
    return this;
  }

  /**
   * Get groupOrderIDs
   * @return groupOrderIDs
   */
  
  @Schema(name = "groupOrderIDs", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("groupOrderIDs")
  public List<String> getGroupOrderIDs() {
    return groupOrderIDs;
  }

  public void setGroupOrderIDs(List<String> groupOrderIDs) {
    this.groupOrderIDs = groupOrderIDs;
  }

  public Group administratorID(String administratorID) {
    this.administratorID = administratorID;
    return this;
  }

  /**
   * Get administratorID
   * @return administratorID
   */
  
  @Schema(name = "administratorID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("administratorID")
  public String getAdministratorID() {
    return administratorID;
  }

  public void setAdministratorID(String administratorID) {
    this.administratorID = administratorID;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Group group = (Group) o;
    return Objects.equals(this.groupID, group.groupID) &&
        Objects.equals(this.name, group.name) &&
        Objects.equals(this.participantIDs, group.participantIDs) &&
        Objects.equals(this.groupOrderIDs, group.groupOrderIDs) &&
        Objects.equals(this.administratorID, group.administratorID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(groupID, name, participantIDs, groupOrderIDs, administratorID);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Group {\n");
    sb.append("    groupID: ").append(toIndentedString(groupID)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    participantIDs: ").append(toIndentedString(participantIDs)).append("\n");
    sb.append("    groupOrderIDs: ").append(toIndentedString(groupOrderIDs)).append("\n");
    sb.append("    administratorID: ").append(toIndentedString(administratorID)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

