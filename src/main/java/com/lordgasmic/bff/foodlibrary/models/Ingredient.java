package com.lordgasmic.bff.foodlibrary.models;

import lombok.Data;

import java.util.List;

@Data
public class Ingredient {
    private long id;
    private long recipeId;
    private String quantity;
    private String uom;
    private String ingredient;
    private List<IngredientPreparation> preparations;
}
