package com.lordgasmic.bff.login.model;

import lombok.Data;

@Data
public class UserInfo {
    private int id;
    private String username;
    private int roles;
    private boolean loggedIn;
}
