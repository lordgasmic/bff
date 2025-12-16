package com.lordgasmic.bff.foodlibrary.models;

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
