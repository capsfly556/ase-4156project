package org.openapitools.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.openapitools.model.FoodProvider;
import java.util.UUID;

@Repository
public interface FoodproviderRepository extends JpaRepository<FoodProvider, UUID> {}
