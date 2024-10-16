package org.openapitools.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.openapitools.model.FoodProvider;
import org.openapitools.model.MenuItem;
import org.openapitools.repository.FoodproviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodproviderService {

  @Autowired private FoodproviderRepository repository;



  public Optional<FoodProvider> findById(String foodProviderId) {
    return repository.findById(UUID.fromString(foodProviderId));
  }

  public Boolean deleteFoodProvider(String foodProviderId) {
    repository.deleteById(UUID.fromString(foodProviderId));
    return !repository.existsById(UUID.fromString(foodProviderId));
  }
  public Boolean checkExistsId(String foodProviderId) {
    return repository.existsById(UUID.fromString(foodProviderId));
  }

  public Optional<FoodProvider> findByName(String name) {
    return repository.findByName(name);
  }

  public Boolean checkExistsNameIdNot(String name, String foodProviderId) {
    UUID uuid = UUID.fromString(foodProviderId);
    return repository.existsByNameAndFoodProviderIDNot(name, uuid );
  }
  public Boolean checkExistsPhoneNumberIdNot(String phoneNumber, String foodProviderId) {
    UUID uuid = UUID.fromString(foodProviderId);
    return repository.existsByPhoneNumberAndFoodProviderIDNot(phoneNumber,uuid);
  }

  public boolean updateFoodProvider(String foodProviderId, FoodProvider updatedProvider) {
    Optional<FoodProvider> existingFoodProviderOptional = repository.findById(UUID.fromString(foodProviderId));

    if (existingFoodProviderOptional.isPresent()) {
      FoodProvider retrievedFoodProvider = existingFoodProviderOptional.get();
      retrievedFoodProvider.setName(updatedProvider.getName());
      retrievedFoodProvider.setLocation(updatedProvider.getLocation());
      retrievedFoodProvider.setPhoneNumber(updatedProvider.getPhoneNumber());
      retrievedFoodProvider.setHoursOfOperation(updatedProvider.getHoursOfOperation());

      List<MenuItem> existingMenuItems = retrievedFoodProvider.getMenu();


      existingMenuItems.clear();
      for (MenuItem updatedMenuItem : updatedProvider.getMenu()) {
        updatedMenuItem.setFoodProvider(retrievedFoodProvider); // Maintain reference to the parent
        existingMenuItems.add(updatedMenuItem); // Modify the existing collection
      }


      repository.save(retrievedFoodProvider);
      return true;

    } else {
      return false;
    }
  }
  public List<FoodProvider> getAllFoodProviders() {
    return repository.findAll();
  }

  public boolean addFoodProvider(FoodProvider foodProvider) {
    if (repository.existsByName(foodProvider.getName()) || repository.existsByPhoneNumber(foodProvider.getPhoneNumber())) {
      return false;
    }

    repository.save(foodProvider);
    return true;
  }

  public void deleteByID(String foodProviderId) {
    repository.deleteById(UUID.fromString(foodProviderId));
  }
}
