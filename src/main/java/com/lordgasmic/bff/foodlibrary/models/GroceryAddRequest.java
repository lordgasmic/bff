package com.lordgasmic.bff.foodlibrary.models;

import lombok.Data;

@Data
public class GroceryAddRequest {
    private String department;
    private String quantity;
    private String item;
}
