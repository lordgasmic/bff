package com.lordgasmic.bff.order.models;

import lombok.Data;

import java.util.List;

@Data
public class Item {
    private String item;
    private List<OrderExtra> extras;
}
