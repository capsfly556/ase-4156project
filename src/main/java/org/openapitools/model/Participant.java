package org.openapitools.model;

import java.util.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.annotation.Generated;

/** Participant */
@Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2024-10-05T01:59:00.934263-04:00[America/Toronto]",
    comments = "Generator version: 7.8.0")
@Entity
public class Participant {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "participant_id", updatable = false, nullable = false)
  private UUID participantID;

  @Column(name = "name", nullable = false)
  private String name;
  
  @Valid @ElementCollection private List<UUID> participantOrderIDs = new ArrayList<>();

  public Participant participantID(UUID participantID) {
    this.participantID = participantID;
    return this;
  }

  /**
   * Get participantID
   *
   * @return participantID
   */
  @Valid
  @Schema(name = "participantID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("participantID")
  public UUID getParticipantID() {
    return participantID;
  }

  public void setParticipantID(UUID participantID) {
    this.participantID = participantID;
  }

  public Participant name(String name) {
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

  public Participant participantOrderIDs(List<UUID> participantOrderIDs) {
    this.participantOrderIDs = participantOrderIDs;
    return this;
  }

  public Participant addParticipantOrderIDsItem(UUID participantOrderIDsItem) {
    if (this.participantOrderIDs == null) {
      this.participantOrderIDs = new ArrayList<>();
    }
    this.participantOrderIDs.add(participantOrderIDsItem);
    return this;
  }

  /**
   * Get participantOrderIDs
   *
   * @return participantOrderIDs
   */
  @Valid
  @Schema(name = "participantOrderIDs", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("participantOrderIDs")
  public List<UUID> getParticipantOrderIDs() {
    return participantOrderIDs;
  }

  public void setParticipantOrderIDs(List<UUID> participantOrderIDs) {
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
    return Objects.equals(this.participantID, participant.participantID)
        && Objects.equals(this.name, participant.name)
        && Objects.equals(this.participantOrderIDs, participant.participantOrderIDs);
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
    sb.append("    participantOrderIDs: ")
        .append(toIndentedString(participantOrderIDs))
        .append("\n");
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
