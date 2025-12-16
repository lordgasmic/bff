package com.lordgasmic.bff.recipe.models;

import lombok.Data;

@Data
public class Direction {
    private long id;
    private long recipeId;
    private String direction;
}
