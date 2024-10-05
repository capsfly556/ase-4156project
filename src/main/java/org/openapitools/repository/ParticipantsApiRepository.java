package org.openapitools.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.openapitools.model.Participant;
import java.util.UUID;

@Repository
public interface ParticipantsApiRepository extends JpaRepository<Participant, UUID> {}
