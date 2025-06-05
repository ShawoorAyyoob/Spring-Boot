package com.shawoor.recipes.repository;

import com.shawoor.recipes.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Recipe findByNameContainingIgnoreCase(String name);

    Recipe findByCuisineContainingIgnoreCaseAndPrepTimeMinutesBetween(String cuisine, int minTime, int maxTime);
}
