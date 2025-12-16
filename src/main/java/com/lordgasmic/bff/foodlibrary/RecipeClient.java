package com.lordgasmic.bff.foodlibrary;

import com.lordgasmic.bff.foodlibrary.models.RecipeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "recipe-client", url = "${recipe-service.url}")
public interface RecipeClient {

    @GetMapping("/api/v1/recipes")
    List<RecipeResponse> getAllRecipes();

    @GetMapping("/api/v1/recipes/{id}")
    RecipeResponse getRecipeById(@PathVariable long id);
}
