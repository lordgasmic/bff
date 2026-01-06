package com.lordgasmic.bff.foodlibrary;

import com.lordgasmic.bff.foodlibrary.models.GroceryAddRequest;
import com.lordgasmic.bff.foodlibrary.models.GroceryListResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "grocery-client", url = "${grocery-service.url}")
public interface GroceryClient {

    @PutMapping("/api/v1/groceries")
    void addGroceryItem(@RequestBody GroceryAddRequest request);

    @GetMapping("/api/v1/groceries")
    List<GroceryListResponse> groceryList();

    @PostMapping("/api/v1/groceries")
    void printGroceryList();
}
