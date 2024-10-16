package org.openapitools;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openapitools.model.FoodProvider;
import org.openapitools.model.MenuItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class foodproviderTest {
    private FoodProvider foodProvider;
    private UUID id;
    private MenuItem menuItem = new MenuItem();
    private List<MenuItem> menu;

    @BeforeEach
    void setUp() {
        id = UUID.randomUUID();
        menu = new ArrayList<>();
        foodProvider = new FoodProvider()
                .foodProviderID(id)
                .name("Test Provider")
                .location("Test Location")
                .phoneNumber("123-456-7890")
                .hoursOfOperation("9 AM - 5 PM");
        menuItem.setName("Fried fries");
        menuItem.setImage("https://www.allrecipes.com/fried-fries/");
        menuItem.setDescription("Crispy golden fried fries");
        menuItem.setCost(new BigDecimal("7.00"));
        menu.add(menuItem);
        menuItem.setFoodProvider(foodProvider);
        foodProvider.setMenu(menu);

    }


    @Test
    void testAddMenuItem() {
        MenuItem menuItem = new MenuItem(); // Assuming MenuItem class has a default constructor
        foodProvider.addMenuItem(menuItem);
        assertEquals(2, foodProvider.getMenu().size());
        assertEquals(menuItem, foodProvider.getMenu().get(1));
    }

}
