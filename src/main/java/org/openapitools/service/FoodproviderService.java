package org.openapitools.service;

import org.openapitools.repository.FoodproviderRepository;
import org.openapitools.model.FoodProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodproviderService {

  @Autowired private FoodproviderRepository repository;

  public FoodProvider addFoodProvider(FoodProvider foodProvider) {
    return repository.save(foodProvider);
  }
}
