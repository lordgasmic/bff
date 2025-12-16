package com.lordgasmic.bff.recipe.models;

import lombok.Data;

@Data
public class IngredientPreparation {
    private long id;
    private long ingredientId;
    private String preparation;
}
