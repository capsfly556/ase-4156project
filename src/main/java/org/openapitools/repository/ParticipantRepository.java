package org.openapitools.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.openapitools.model.Participant;
import org.openapitools.model.ParticipantOrder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, UUID> {
  /**
   * Find all participant order IDs for a given participant ID.
   *
   * @param participantID The ID of the participant.
   * @return A list of participant orders corresponding to the given participant ID.
   */
  @Query("SELECT po FROM ParticipantOrder po " +
         "WHERE po.participantOrderID IN (SELECT p.participantOrderID " +
         "FROM participant_participant_orderids p WHERE p.participantID = :participantID)")
  List<ParticipantOrder> findOrdersByParticipantID(UUID participantID);

  @Query("SELECT CASE WHEN COUNT(po) > 0 THEN true ELSE false END FROM ParticipantOrder po " +
       "WHERE po.participantOrderID = :participantOrderID AND po.participant.participantID = :participantID")
  boolean existsByParticipantIDAndOrderID(UUID participantID, UUID participantOrderID);

  @Query("DELETE FROM participant_participant_orderids ppo WHERE ppo.participantID = :participantID AND ppo.participantOrderID = :participantOrderID")
  void unlinkOrderFromParticipant(UUID participantID, UUID participantOrderID);

  @Query("DELETE FROM ParticipantOrder po WHERE po.participantOrderID = :participantOrderID AND po.participant.participantID = :participantID")
  void deleteOrderByParticipantIDAndOrderID(UUID participantID, UUID participantOrderID);

  @Query("SELECT po FROM ParticipantOrder po " +
       "WHERE po.participantOrderID = :participantOrderID AND po.participant.participantID = :participantID")
  Optional<ParticipantOrder> findOrderByParticipantIDAndParticipantOrderID(UUID participantID, UUID participantOrderID);

  @Query("INSERT INTO ParticipantOrder (participantOrderID, comments) VALUES (:participantOrderID, :comments)")
  void saveParticipantOrder(UUID participantOrderID, String comments);

  @Query("INSERT INTO participant_order_menu_itemids (participantOrderID, menu_item_id, count) VALUES (:participantOrderID, :menuItemID, :count)")
  void linkMenuItemToOrder(UUID participantOrderID, UUID menuItemID, Integer count);

}
