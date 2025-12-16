package com.lordgasmic.bff.foodlibrary;

import com.lordgasmic.bff.foodlibrary.models.RecipeResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    private final RecipeClient recipeClient;

    public RecipeService(final RecipeClient recipeClient) {
        this.recipeClient = recipeClient;
    }

    public List<RecipeResponse> getRecipes() {
        return recipeClient.getAllRecipes();
    }

    public RecipeResponse getRecipeById(final long id) {
        return recipeClient.getRecipeById(id);
    }
}
