package com.shawoor.recipes.services;

import com.shawoor.recipes.model.Recipe;
import com.shawoor.recipes.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository, RecipeRepository recipeRepository1) {
        this.recipeRepository = recipeRepository1;
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id).orElse(null);
    }

    public Recipe createRecipe(Recipe recipe) {
        if (recipe == null) {
            return null;
        } else {
            return recipeRepository.save(recipe);
        }
    }

    public Recipe searchRecipeName(String name) {
        return recipeRepository.findByNameContainingIgnoreCase(name);
    }

    public Recipe filterCuisineAndPrep(String cuisine, int minTime, int maxTime) {
        return recipeRepository.findByCuisineContainingIgnoreCaseAndPrepTimeMinutesBetween(cuisine, minTime, maxTime);
    }

    public Recipe updateRecipe(Long id, Recipe newRecipe) {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(id);
        if (optionalRecipe.isEmpty()) {
            return null;
        } else {
            Recipe recipe = optionalRecipe.get();
            recipe.setName(newRecipe.getName());
            recipe.setIngredients(newRecipe.getIngredients());
            recipe.setCuisine(newRecipe.getCuisine());
            recipe.setRating(newRecipe.getRating());
            recipe.setPrepTimeMinutes(newRecipe.getPrepTimeMinutes());
            return recipeRepository.save(newRecipe);
        }

    }

    public boolean deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
        return false;
    }
}
