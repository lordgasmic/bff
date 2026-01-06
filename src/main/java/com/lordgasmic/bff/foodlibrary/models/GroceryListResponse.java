package com.lordgasmic.bff.foodlibrary.models;

import lombok.Data;

@Data
public class GroceryListResponse {
    private long id;
    private String department;
    private String quantity;
    private String item;
}
