package org.openapitools.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.openapitools.model.Group;
import java.util.UUID;

@Repository
public interface GroupRepository extends JpaRepository<Group, UUID> {}
