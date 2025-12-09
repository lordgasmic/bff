package com.lordgasmic.bff.collection;

import com.lordgasmic.bff.collection.model.GasRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CollectionController {

    private final CollectionService service;

    public CollectionController(final CollectionService service) {
        this.service = service;
    }

    @PutMapping("/api/v1/gas")
    public Object addGas(@RequestBody final GasRequest request) {
        return service.addGas(request);
    }

    @GetMapping("/api/v1/gas")
    public Object getGas(@RequestParam final String vehicle) {
        return service.getGas(vehicle);
    }
}
