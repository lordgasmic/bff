package com.lordgasmic.bff.meme.model;

import lombok.Data;

import java.util.List;

@Data
public class MemeResponse {
    private String name;
    private String url;
    private List<String> tags;
}
