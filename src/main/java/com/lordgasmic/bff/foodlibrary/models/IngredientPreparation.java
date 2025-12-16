package com.lordgasmic.bff.foodlibrary.models;

import lombok.Data;

@Data
public class IngredientPreparation {
    private long id;
    private long ingredientId;
    private String preparation;
}
