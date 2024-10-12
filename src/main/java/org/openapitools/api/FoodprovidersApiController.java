package org.openapitools.api;

import org.openapitools.model.FoodProvider;

import org.openapitools.service.FoodproviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import javax.annotation.Generated;

@Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2024-10-02T19:11:02.971027-04:00[America/Toronto]",
    comments = "Generator version: 7.8.0")
@Controller
@RequestMapping("${openapi.groupGrub.base-path:}")
public class FoodprovidersApiController implements FoodprovidersApi {

  private final NativeWebRequest request;
  private final FoodproviderService foodproviderService;

  @Autowired
  public FoodprovidersApiController(
      NativeWebRequest request, FoodproviderService foodproviderService) {
    this.request = request;
    this.foodproviderService = foodproviderService;
  }

  @Override
  public Optional<NativeWebRequest> getRequest() {
    return Optional.ofNullable(request);
  }

  @Override
  public ResponseEntity<Void> foodprovidersPost(@Valid @RequestBody FoodProvider foodProvider) {
    if (foodProvider.getMenu() == null || foodProvider.getMenu().isEmpty()) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    foodProvider.getMenu().forEach(menuItem -> {

      menuItem.setFoodProvider(foodProvider);
    });

    Boolean added = foodproviderService.addFoodProvider(foodProvider);
    if (added) {
      return new ResponseEntity<>(HttpStatus.CREATED);
    }
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }


  @Override
  public ResponseEntity<Void> foodprovidersFoodProviderIdDelete(String foodProviderId){
    try {
      System.out.println("Received foodProviderId: " + foodProviderId);
      UUID uuid = UUID.fromString(foodProviderId);
      System.out.print("uuid"+uuid);
      Optional<FoodProvider> foodProviderOptional = foodproviderService.findById(foodProviderId);

      if (foodProviderOptional.isPresent()) {
        Boolean deleteStatus = foodproviderService.deleteFoodProvider(foodProviderId);

        if (deleteStatus) {
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @Override
  public ResponseEntity<FoodProvider> foodprovidersFoodProviderIdGet(String foodProviderId) {
    try {
      Optional<FoodProvider> foodProviderOptional = foodproviderService.findById(foodProviderId);

      if (foodProviderOptional.isPresent()) {
        return new ResponseEntity<>(foodProviderOptional.get(), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @Override
  public ResponseEntity<Void> foodprovidersFoodProviderIdPut(String foodProviderId,
                                                             @Valid @RequestBody FoodProvider foodProvider) {
    try {
      boolean updated = foodproviderService.updateFoodProvider(foodProviderId, foodProvider);

      if(updated){
        return new ResponseEntity<>(HttpStatus.OK);
      }else if (foodproviderService.checkExistsPhoneNumberIdNot(foodProvider.getPhoneNumber(), foodProviderId) ||
              foodproviderService.checkExistsNameIdNot(foodProvider.getName(), foodProviderId)) {
        return new ResponseEntity<>(HttpStatus.CONFLICT);}
        else{
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
      } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }


  @Override
  public ResponseEntity<List<FoodProvider>> foodprovidersGet() {
    List<FoodProvider> foodProviders = foodproviderService.getAllFoodProviders();

    if (foodProviders.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } else {
      return new ResponseEntity<>(foodProviders, HttpStatus.OK);
    }
  }
}
