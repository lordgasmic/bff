package com.lordgasmic.bff.foodlibrary;

import com.lordgasmic.bff.foodlibrary.models.GroceryAddRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroceryController {

    private final GroceryService service;

    public GroceryController(final GroceryService service) {
        this.service = service;
    }

    @PutMapping("/api/v1/grocery")
    public ResponseEntity<Void> addGroceryItem(@RequestBody final GroceryAddRequest request) {
        service.addGroceryItem(request);

        return ResponseEntity.accepted().build();
    }
}
