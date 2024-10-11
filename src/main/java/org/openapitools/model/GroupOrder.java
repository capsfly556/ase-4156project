package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.validation.Valid;
import org.hibernate.annotations.GenericGenerator;

/** GroupOrder */
@Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2024-10-05T01:59:00.934263-04:00[America/Toronto]",
    comments = "Generator version: 7.8.0")
@Entity
public class GroupOrder {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private UUID groupOrderID;

  @Column(nullable = false)
  private String status;

  @Valid
  @ElementCollection
  @MapKeyColumn(name = "menu_item_id")
  @Column(name = "count")

  private Map<UUID, Integer> menuItemCounts = new HashMap<>();

  @Valid @ElementCollection private List<UUID> participantOrderIDs = new ArrayList<>();

  @Column(nullable = false)
  private String desiredPickupTimeframe;

  @Column(nullable = false)
  private UUID foodProviderID;

  public GroupOrder groupOrderID(UUID groupOrderID) {
    this.groupOrderID = groupOrderID;
    return this;
  }

  /**
   * Get groupOrderID
   *
   * @return groupOrderID
   */
  @Valid
  @Schema(name = "groupOrderID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("groupOrderID")
  public UUID getGroupOrderID() {
    return groupOrderID;
  }

  public void setGroupOrderID(UUID groupOrderID) {
    this.groupOrderID = groupOrderID;
  }

  public GroupOrder status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   *
   * @return status
   */
  @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public GroupOrder menuItemCounts(Map<UUID, Integer> menuItemCounts) {
    this.menuItemCounts = menuItemCounts;
    return this;
  }

  public GroupOrder putMenuItemCounts(UUID key, Integer menuItemIDsItem) {
    if (this.menuItemCounts == null) {
      this.menuItemCounts = new HashMap<>();
    }
    this.menuItemCounts.put(key, menuItemIDsItem);
    return this;
  }

  /**
   * Get menuItemIDs
   *
   * @return menuItemIDs
   */
  @Schema(name = "menuItemIDs", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("menuItemIDs")

  public Map<UUID, Integer> getMenuItemCounts() {
    return menuItemCounts;
  }

  public void setMenuItemCounts(Map<UUID, Integer> menuItemCounts) {
    this.menuItemCounts = menuItemCounts;

  }

  public GroupOrder participantOrderIDs(List<UUID> participantOrderIDs) {
    this.participantOrderIDs = participantOrderIDs;
    return this;
  }

  public GroupOrder addParticipantOrderIDsItem(UUID participantOrderIDsItem) {
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

  public GroupOrder desiredPickupTimeframe(String desiredPickupTimeframe) {
    this.desiredPickupTimeframe = desiredPickupTimeframe;
    return this;
  }

  /**
   * Get desiredPickupTimeframe
   *
   * @return desiredPickupTimeframe
   */
  @Schema(name = "desiredPickupTimeframe", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("desiredPickupTimeframe")
  public String getDesiredPickupTimeframe() {
    return desiredPickupTimeframe;
  }

  public void setDesiredPickupTimeframe(String desiredPickupTimeframe) {
    this.desiredPickupTimeframe = desiredPickupTimeframe;
  }

  public GroupOrder foodProviderID(UUID foodProviderID) {
    this.foodProviderID = foodProviderID;
    return this;
  }

  /**
   * Get foodProviderID
   *
   * @return foodProviderID
   */
  @Valid
  @Schema(name = "foodProviderID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("foodProviderID")
  public UUID getFoodProviderID() {
    return foodProviderID;
  }

  public void setFoodProviderID(UUID foodProviderID) {
    this.foodProviderID = foodProviderID;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GroupOrder groupOrder = (GroupOrder) o;
    return Objects.equals(this.groupOrderID, groupOrder.groupOrderID)
        && Objects.equals(this.status, groupOrder.status)
        && Objects.equals(this.menuItemCounts, groupOrder.menuItemCounts)
        && Objects.equals(this.participantOrderIDs, groupOrder.participantOrderIDs)
        && Objects.equals(this.desiredPickupTimeframe, groupOrder.desiredPickupTimeframe)
        && Objects.equals(this.foodProviderID, groupOrder.foodProviderID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        groupOrderID,
        status,
            menuItemCounts,
        participantOrderIDs,
        desiredPickupTimeframe,
        foodProviderID);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GroupOrder {\n");
    sb.append("    groupOrderID: ").append(toIndentedString(groupOrderID)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    menuItemIDs: ").append(toIndentedString(menuItemCounts)).append("\n");
    sb.append("    participantOrderIDs: ")
        .append(toIndentedString(participantOrderIDs))
        .append("\n");
    sb.append("    desiredPickupTimeframe: ")
        .append(toIndentedString(desiredPickupTimeframe))
        .append("\n");
    sb.append("    foodProviderID: ").append(toIndentedString(foodProviderID)).append("\n");
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
