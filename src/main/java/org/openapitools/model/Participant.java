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
 * Participant
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-02T19:11:02.971027-04:00[America/Toronto]", comments = "Generator version: 7.8.0")
public class Participant {

  private String participantID;

  private String name;

  @Valid
  private List<String> participantOrderIDs = new ArrayList<>();

  public Participant participantID(String participantID) {
    this.participantID = participantID;
    return this;
  }

  /**
   * Get participantID
   * @return participantID
   */
  
  @Schema(name = "participantID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("participantID")
  public String getParticipantID() {
    return participantID;
  }

  public void setParticipantID(String participantID) {
    this.participantID = participantID;
  }

  public Participant name(String name) {
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

  public Participant participantOrderIDs(List<String> participantOrderIDs) {
    this.participantOrderIDs = participantOrderIDs;
    return this;
  }

  public Participant addParticipantOrderIDsItem(String participantOrderIDsItem) {
    if (this.participantOrderIDs == null) {
      this.participantOrderIDs = new ArrayList<>();
    }
    this.participantOrderIDs.add(participantOrderIDsItem);
    return this;
  }

  /**
   * Get participantOrderIDs
   * @return participantOrderIDs
   */
  
  @Schema(name = "participantOrderIDs", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("participantOrderIDs")
  public List<String> getParticipantOrderIDs() {
    return participantOrderIDs;
  }

  public void setParticipantOrderIDs(List<String> participantOrderIDs) {
    this.participantOrderIDs = participantOrderIDs;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Participant participant = (Participant) o;
    return Objects.equals(this.participantID, participant.participantID) &&
        Objects.equals(this.name, participant.name) &&
        Objects.equals(this.participantOrderIDs, participant.participantOrderIDs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(participantID, name, participantOrderIDs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Participant {\n");
    sb.append("    participantID: ").append(toIndentedString(participantID)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    participantOrderIDs: ").append(toIndentedString(participantOrderIDs)).append("\n");
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

