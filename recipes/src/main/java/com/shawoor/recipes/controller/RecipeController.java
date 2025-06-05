package com.shawoor.recipes.controller;

import com.shawoor.recipes.model.Recipe;
import com.shawoor.recipes.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("recipes")
public class RecipeController {
    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/{id}")
    public Recipe getRecipeById(@PathVariable Long id) {
        return recipeService.getRecipeById(id);
    }

    @GetMapping("/search")
    public Recipe searchRecipeName(@RequestParam String name) {
        return recipeService.searchRecipeName(name);
    }

    @GetMapping("/filter")
    public Recipe filterCuisineAndPrep(@RequestParam String cuisine, int minTime, int maxTime) {
        return recipeService.filterCuisineAndPrep(cuisine, minTime, maxTime);
    }

    @PostMapping
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return recipeService.createRecipe(recipe);
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@PathVariable Long id, @RequestBody Recipe recipe) {
        return recipeService.updateRecipe(id, recipe);
    }

    @DeleteMapping("/{id}")
    public Recipe deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
        return null;
    }
}
