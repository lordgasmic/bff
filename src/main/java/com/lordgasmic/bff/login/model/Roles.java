package com.lordgasmic.bff.login.model;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Optional;

@AllArgsConstructor
public enum Roles {
    user(1), feeding(2);

    private final int permission;

    public static Roles fromValue(int value) {
        Optional<Roles> role =  Arrays.stream(Roles.values()).filter(r -> r.permission == value).findFirst();

        return role.orElse(null);
    }
}
