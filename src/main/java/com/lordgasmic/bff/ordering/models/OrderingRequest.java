package com.lordgasmic.bff.ordering.models;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class OrderingRequest implements Serializable {
    private String message;
    private PrintType type;
    private Map<String, List<String>> properties;
}
