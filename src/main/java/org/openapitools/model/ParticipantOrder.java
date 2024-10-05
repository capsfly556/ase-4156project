package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.hibernate.annotations.GenericGenerator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ElementCollection;
import javax.persistence.MapKeyColumn;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ParticipantOrder
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-05T01:59:00.934263-04:00[America/Toronto]", comments = "Generator version: 7.8.0")
@Entity
public class ParticipantOrder {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
          name = "UUID",
          strategy = "org.hibernate.id.UUIDGenerator"
  )
  private UUID participantOrderID;

  @Valid
  @ElementCollection
  @MapKeyColumn(name = "menu_item_name")
  @Column(name = "menu_item_id")
  private Map<String, Integer> menuItemIDs = new HashMap<>();

  @Column(nullable = false)
  private String comments;

  public ParticipantOrder participantOrderID(UUID participantOrderID) {
    this.participantOrderID = participantOrderID;
    return this;
  }

  /**
   * Get participantOrderID
   * @return participantOrderID
   */
  @Valid 
  @Schema(name = "participantOrderID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("participantOrderID")
  public UUID getParticipantOrderID() {
    return participantOrderID;
  }

  public void setParticipantOrderID(UUID participantOrderID) {
    this.participantOrderID = participantOrderID;
  }

  public ParticipantOrder menuItemIDs(Map<String, Integer> menuItemIDs) {
    this.menuItemIDs = menuItemIDs;
    return this;
  }

  public ParticipantOrder putMenuItemIDsItem(String key, Integer menuItemIDsItem) {
    if (this.menuItemIDs == null) {
      this.menuItemIDs = new HashMap<>();
    }
    this.menuItemIDs.put(key, menuItemIDsItem);
    return this;
  }

  /**
   * Get menuItemIDs
   * @return menuItemIDs
   */
  
  @Schema(name = "menuItemIDs", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("menuItemIDs")
  public Map<String, Integer> getMenuItemIDs() {
    return menuItemIDs;
  }

  public void setMenuItemIDs(Map<String, Integer> menuItemIDs) {
    this.menuItemIDs = menuItemIDs;
  }

  public ParticipantOrder comments(String comments) {
    this.comments = comments;
    return this;
  }

  /**
   * Get comments
   * @return comments
   */
  
  @Schema(name = "comments", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("comments")
  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ParticipantOrder participantOrder = (ParticipantOrder) o;
    return Objects.equals(this.participantOrderID, participantOrder.participantOrderID) &&
        Objects.equals(this.menuItemIDs, participantOrder.menuItemIDs) &&
        Objects.equals(this.comments, participantOrder.comments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(participantOrderID, menuItemIDs, comments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ParticipantOrder {\n");
    sb.append("    participantOrderID: ").append(toIndentedString(participantOrderID)).append("\n");
    sb.append("    menuItemIDs: ").append(toIndentedString(menuItemIDs)).append("\n");
    sb.append("    comments: ").append(toIndentedString(comments)).append("\n");
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

