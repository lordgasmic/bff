package com.lordgasmic.bff.funko;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class FunkoController {

    private final FunkoService service;

    public FunkoController(final FunkoService service) {
        this.service = service;
    }

    @GetMapping("/api/v1/funkos")
    public ResponseEntity<Object> getFunkos(@RequestParam final Optional<Integer> from, @RequestParam final Optional<Integer> size) {
        final Object object = service.getFunkos(from.orElse(0), size.orElse(10));
        return ResponseEntity.ok(object);
    }

    @GetMapping("/api/v1/funkos/{id}")
    public ResponseEntity<Object> getFunkos(@PathVariable final String id) {
        final Object object = service.getFunkoById(id);
        return ResponseEntity.ok(object);
    }

    @PostMapping("/api/v1/funkos")
    public ResponseEntity<Void> index(@RequestBody final FunkoRequest request) {
        service.addFunko(request);
        return ResponseEntity.accepted().build();
    }
}
