package org.openapitools.service;

import org.openapitools.repository.FoodprovidersApiRepository;
import org.openapitools.model.FoodProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodprovidersApiService {

    @Autowired
    private FoodprovidersApiRepository repository;

    public FoodProvider addFoodProvider(FoodProvider foodProvider) {
        return repository.save(foodProvider);
    }
}
