package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.annotation.Generated;
import javax.naming.Name;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Table;

/** Group */
@Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2024-10-05T01:59:00.934263-04:00[America/Toronto]",
    comments = "Generator version: 7.8.0")
@Entity
@Table(name = "`group`")
public class Group {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Type(type="org.hibernate.type.UUIDCharType")
  private UUID groupID;

  @Column(nullable = false)
  private String name;

  @Valid @ElementCollection
  @Type(type="org.hibernate.type.UUIDCharType")
  private List<UUID> participantIDs = new ArrayList<>();

  @Valid @ElementCollection
  @Type(type="org.hibernate.type.UUIDCharType")
  private List<UUID> groupOrderIDs = new ArrayList<>();

  @Column(nullable = false)
  @Type(type="org.hibernate.type.UUIDCharType")
  private UUID administratorID;

  public Group groupID(UUID groupID) {
    this.groupID = groupID;
    return this;
  }

  /**
   * Get groupID
   *
   * @return groupID
   */
  @Valid
  @Schema(name = "groupID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("groupID")
  public UUID getGroupID() {
    return groupID;
  }

  public void setGroupID(UUID groupID) {
    this.groupID = groupID;
  }

  public Group name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   *
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

  public Group participantIDs(List<UUID> participantIDs) {
    this.participantIDs = participantIDs;
    return this;
  }

  public Group addParticipantIDsItem(UUID participantIDsItem) {
    if (this.participantIDs == null) {
      this.participantIDs = new ArrayList<>();
    }
    this.participantIDs.add(participantIDsItem);
    return this;
  }

  /**
   * Get participantIDs
   *
   * @return participantIDs
   */
  @Valid
  @Schema(name = "participantIDs", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("participantIDs")
  public List<UUID> getParticipantIDs() {
    return participantIDs;
  }

  public void setParticipantIDs(List<UUID> participantIDs) {
    this.participantIDs = participantIDs;
  }

  public Group groupOrderIDs(List<UUID> groupOrderIDs) {
    this.groupOrderIDs = groupOrderIDs;
    return this;
  }

  public Group addGroupOrderIDsItem(UUID groupOrderIDsItem) {
    if (this.groupOrderIDs == null) {
      this.groupOrderIDs = new ArrayList<>();
    }
    this.groupOrderIDs.add(groupOrderIDsItem);
    return this;
  }

  /**
   * Get groupOrderIDs
   *
   * @return groupOrderIDs
   */
  @Valid
  @Schema(name = "groupOrderIDs", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("groupOrderIDs")
  public List<UUID> getGroupOrderIDs() {
    return groupOrderIDs;
  }

  public void setGroupOrderIDs(List<UUID> groupOrderIDs) {
    this.groupOrderIDs = groupOrderIDs;
  }

  public Group administratorID(UUID administratorID) {
    this.administratorID = administratorID;
    return this;
  }

  /**
   * Get administratorID
   *
   * @return administratorID
   */
  @Valid
  @Schema(name = "administratorID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("administratorID")
  public UUID getAdministratorID() {
    return administratorID;
  }

  public void setAdministratorID(UUID administratorID) {
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
    return Objects.equals(this.groupID, group.groupID)
        && Objects.equals(this.name, group.name)
        && Objects.equals(this.participantIDs, group.participantIDs)
        && Objects.equals(this.groupOrderIDs, group.groupOrderIDs)
        && Objects.equals(this.administratorID, group.administratorID);
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
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
