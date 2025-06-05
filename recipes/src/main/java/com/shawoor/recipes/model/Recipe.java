package com.shawoor.recipes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String ingredients;
    private double prepTimeMinutes;
    private String cuisine;
    private float rating;

    public Recipe() {
    }

    public Recipe(Long id, String name, String ingredients, double prepTimeMinutes, String cuisine, float rating) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.prepTimeMinutes = prepTimeMinutes;
        this.cuisine = cuisine;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public double getPrepTimeMinutes() {
        return prepTimeMinutes;
    }

    public void setPrepTimeMinutes(double prepTimeMinutes) {
        this.prepTimeMinutes = prepTimeMinutes;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
