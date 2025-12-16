package com.lordgasmic.bff.foodlibrary;

import com.lordgasmic.bff.foodlibrary.models.GroceryAddRequest;
import org.springframework.stereotype.Service;

@Service
public class GroceryService {

    private final GroceryClient client;

    public GroceryService(GroceryClient client) {
        this.client = client;
    }

    public void addGroceryItem(GroceryAddRequest request) {
        client.addGroceryItem(request);
    }
}
