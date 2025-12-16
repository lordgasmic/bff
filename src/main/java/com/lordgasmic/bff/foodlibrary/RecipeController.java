package com.lordgasmic.bff.foodlibrary;

import com.lordgasmic.bff.foodlibrary.models.RecipeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(final RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/api/v1/recipes")
    public ResponseEntity<List<RecipeResponse>> getAllRecipes() {
        final List<RecipeResponse> recipes = recipeService.getRecipes();
        return ResponseEntity.ok(recipes);
    }

    @GetMapping("/api/v1/recipes/{id}")
    public ResponseEntity<RecipeResponse> getRecipeById(@PathVariable final long id) {
        final RecipeResponse recipe = recipeService.getRecipeById(id);
        return ResponseEntity.ok(recipe);
    }
}
