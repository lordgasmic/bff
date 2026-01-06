package com.lordgasmic.bff.order.models;

import lombok.Data;

@Data
public class OrderRequestOutbound {
    private String message;
    private PrintType type;
    private Object properties;
    private String user;
}
