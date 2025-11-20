package com.lordgasmic.bff.ordering.models;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class OrderingRequest {
    private String message;
    private PrintType type;
    private Map<String, List<String>> properties;
}
