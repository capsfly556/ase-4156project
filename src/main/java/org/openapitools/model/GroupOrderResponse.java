package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.validation.Valid;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.Generated;

/** GroupOrderResponse */
@Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2024-10-05T01:59:00.934263-04:00[America/Toronto]",
    comments = "Generator version: 7.8.0")
public class GroupOrderResponse {

  private UUID groupOrderID;

  private String status;

  @Valid private Map<UUID, Integer> menuItemCounts = new HashMap<>();

  @Valid private List<UUID> participantOrderIDs = new ArrayList<>();

  private String desiredPickupTimeframe;

  private UUID foodProviderID;

  @Valid private List<@Valid ParticipantOrder> participantOrders = new ArrayList<>();

  public GroupOrderResponse groupOrderID(UUID groupOrderID) {
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

  public GroupOrderResponse status(String status) {
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

  public GroupOrderResponse menuItemCounts(Map<UUID, Integer> menuItemCounts) {
    this.menuItemCounts = menuItemCounts;
    return this;
  }

  public GroupOrderResponse putMenuItemCounts(UUID key, Integer menuItemIDsItem) {
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

  public GroupOrderResponse participantOrderIDs(List<UUID> participantOrderIDs) {
    this.participantOrderIDs = participantOrderIDs;
    return this;
  }

  public GroupOrderResponse addParticipantOrderIDsItem(UUID participantOrderIDsItem) {
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

  public GroupOrderResponse desiredPickupTimeframe(String desiredPickupTimeframe) {
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

  public GroupOrderResponse foodProviderID(UUID foodProviderID) {
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

  public GroupOrderResponse participantOrders(List<@Valid ParticipantOrder> participantOrders) {
    this.participantOrders = participantOrders;
    return this;
  }

  public GroupOrderResponse addParticipantOrdersItem(ParticipantOrder participantOrdersItem) {
    if (this.participantOrders == null) {
      this.participantOrders = new ArrayList<>();
    }
    this.participantOrders.add(participantOrdersItem);
    return this;
  }

  /**
   * Get participantOrders
   *
   * @return participantOrders
   */
  @Valid
  @Schema(name = "participantOrders", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("participantOrders")
  public List<@Valid ParticipantOrder> getParticipantOrders() {
    return participantOrders;
  }

  public void setParticipantOrders(List<@Valid ParticipantOrder> participantOrders) {
    this.participantOrders = participantOrders;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GroupOrderResponse groupOrderResponse = (GroupOrderResponse) o;
    return Objects.equals(this.groupOrderID, groupOrderResponse.groupOrderID)
        && Objects.equals(this.status, groupOrderResponse.status)
        && Objects.equals(this.menuItemCounts, groupOrderResponse.menuItemCounts)
        && Objects.equals(this.participantOrderIDs, groupOrderResponse.participantOrderIDs)
        && Objects.equals(this.desiredPickupTimeframe, groupOrderResponse.desiredPickupTimeframe)
        && Objects.equals(this.foodProviderID, groupOrderResponse.foodProviderID)
        && Objects.equals(this.participantOrders, groupOrderResponse.participantOrders);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        groupOrderID,
        status,
            menuItemCounts,
        participantOrderIDs,
        desiredPickupTimeframe,
        foodProviderID,
        participantOrders);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GroupOrderResponse {\n");
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
    sb.append("    participantOrders: ").append(toIndentedString(participantOrders)).append("\n");
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
