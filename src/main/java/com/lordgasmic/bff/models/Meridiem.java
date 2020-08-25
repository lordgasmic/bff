package com.lordgasmic.bff.models;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Meridiem {
    am("am"), pm("pm");

    private String meridiem;
}
