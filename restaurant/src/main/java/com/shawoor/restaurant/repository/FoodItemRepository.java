package com.shawoor.restaurant.repository;

import com.shawoor.restaurant.controller.FoodItemController;
import com.shawoor.restaurant.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
}
