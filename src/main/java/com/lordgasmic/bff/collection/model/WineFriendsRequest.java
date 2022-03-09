package com.lordgasmic.bff.collection.model;

import lombok.Data;

import java.util.List;

@Data
public class WineFriendsRequest {
    List<String> users;
    List<String> wineIds;
}
