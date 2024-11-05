package org.openapitools.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.openapitools.model.Participant;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, UUID> {
    @Query("SELECT u FROM Participant u WHERE u.name = ?1")
    Optional<Participant> findUserByName(String name);
}
