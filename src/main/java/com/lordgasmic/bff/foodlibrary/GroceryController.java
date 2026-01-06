package com.lordgasmic.bff.foodlibrary;

import com.lordgasmic.bff.foodlibrary.models.GroceryAddRequest;
import com.lordgasmic.bff.foodlibrary.models.GroceryListResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroceryController {

    private final GroceryService service;

    public GroceryController(final GroceryService service) {
        this.service = service;
    }

    @PutMapping("/api/v1/groceries")
    public ResponseEntity<Void> addGroceryItem(@RequestBody final GroceryAddRequest request) {
        service.addGroceryItem(request);

        return ResponseEntity.accepted().build();
    }

    @GetMapping("/api/v1/groceries")
    public ResponseEntity<List<GroceryListResponse>> groceryList() {
        return ResponseEntity.ok(service.groceryList());
    }

    @PostMapping("/api/v1/groceries")
    public ResponseEntity<Void> printGrocerList() {
        service.printGroceryList();

        return ResponseEntity.accepted().build();
    }
}
