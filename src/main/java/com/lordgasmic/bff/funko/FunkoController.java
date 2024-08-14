package com.lordgasmic.bff.funko;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class FunkoController {

    private final FunkoService service;

    public FunkoController(FunkoService service) {
        this.service = service;
    }

    @GetMapping("/api/v1/funkos")
    public Object getFunkos(@RequestParam Optional<Integer> start, @RequestParam Optional<Integer> count) {
        return service.getFunkos(start.orElse(0), count.orElse(10));
    }

    @PutMapping("/api/v1/funkos")
    public Object index() {
        return service.index();
    }
}
