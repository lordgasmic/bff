package com.lordgasmic.bff.order.models;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class OrderRequestOutbound {
    private String message;
    private PrintType type;
    private Map<String, List<OrderExtra>> properties;
    private String user;
}
