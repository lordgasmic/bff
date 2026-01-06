package com.lordgasmic.bff.foodlibrary;

import com.lordgasmic.bff.foodlibrary.models.GroceryAddRequest;
import com.lordgasmic.bff.foodlibrary.models.GroceryListResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryService {

    private final GroceryClient client;

    public GroceryService(final GroceryClient client) {
        this.client = client;
    }

    public void addGroceryItem(final GroceryAddRequest request) {
        client.addGroceryItem(request);
    }

    public List<GroceryListResponse> groceryList() {
        return client.groceryList();
    }

    public void printGroceryList() {
        client.printGroceryList();
    }
}
