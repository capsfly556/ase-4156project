package org.openapitools.repository;

import org.openapitools.model.Group;
import org.openapitools.model.GroupOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GroupOrderRepository extends JpaRepository<GroupOrder, UUID> {}
