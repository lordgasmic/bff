package com.lordgasmic.bff.funko;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FunkoController {

    private final FunkoService service;

    public FunkoController(FunkoService service) {
        this.service = service;
    }

    @GetMapping("/api/v1/funkos")
    public Object getFunkos() {
        return service.getFunkos();
    }

    @PutMapping("/api/v1/funkos")
    public Object index() {
        return service.index();
    }
}
