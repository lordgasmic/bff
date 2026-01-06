package com.lordgasmic.bff.order.models;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OrderRequest implements Serializable {
    private String message;
    private PrintType type;
    private List<Item> properties;
}
