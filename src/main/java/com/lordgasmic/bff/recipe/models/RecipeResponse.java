package com.lordgasmic.bff.recipe.models;

import lombok.Data;

import java.util.List;

@Data
public class RecipeResponse {
    private Long id;
    private String name;
    private String description;
    private List<Ingredient> ingredients;
    private List<Direction> directions;
}
