package com.lordgasmic.bff.funko;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "funko-client", url = "${funko-service.url}")
public interface FunkoClient {

    @GetMapping(value = "/api/v1/funkos", headers = {""})
    Object getFunkos(@RequestParam int from, @RequestParam int size);


    @GetMapping(value = "/api/v1/funkos/{id}", headers = {""})
    Object getFunkoById(String id);

    @PostMapping(value = "/api/v1/funkos", headers = {""})
    void addFunko(@RequestBody FunkoRequest request);
}
