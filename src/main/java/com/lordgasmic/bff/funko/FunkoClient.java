package com.lordgasmic.bff.funko;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "funko-client", url = "${funko-service.url}")
public interface FunkoClient {

    @GetMapping(value = "/api/v1/funkos", headers = {""})
    Object getFunkos();

    @PutMapping(value="/api/v1/funkos", headers = {""})
    Object index();
}
