package com.shawoor.restaurant.controller;

import com.shawoor.restaurant.model.FoodItem;
import com.shawoor.restaurant.services.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fooditems")
public class FoodItemController {
    private final FoodItemService foodService;
    @Autowired

    public FoodItemController(FoodItemService foodService) {
        this.foodService = foodService;
    }
    @GetMapping
    public List<FoodItem> getAllFoodItems(){
        return foodService.getAllFoodItems();
    }
}
