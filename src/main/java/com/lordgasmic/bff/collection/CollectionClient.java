package com.lordgasmic.bff.collection;

import com.lordgasmic.bff.collection.model.GasRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "collection-client", url = "${collection-service.url}")
public interface CollectionClient {

    @PutMapping(value = "/api/v1/gas", headers = {""})
    Object addGas(@RequestBody GasRequest request);

    @GetMapping(value = "/api/v1/gas", headers = {""})
    Object getGas(@RequestParam String vehicle);
}
