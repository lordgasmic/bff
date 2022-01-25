package com.lordgasmic.bff.collection;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class CollectionController {

    private final CollectionService service;

    public CollectionController(final CollectionService service) {
        this.service = service;
    }

    @GetMapping("/api/v1/wineries")
    public List<Object> getWineries() {
        return service.getWineries();
    }
}