package com.shawoor.restaurant.services;

import com.shawoor.restaurant.controller.FoodItemController;
import com.shawoor.restaurant.model.FoodItem;
import com.shawoor.restaurant.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemService {
 private final FoodItemRepository foodItemRepository;
 @Autowired
    public FoodItemService(FoodItemRepository repository) {
        this.foodItemRepository = repository;
    }
    public List<FoodItem> getAllFoodItems(){
     return foodItemRepository.findAll();
    }
}
