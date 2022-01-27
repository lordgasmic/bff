package com.lordgasmic.bff.collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "collection-client", url = "${collection-service.url}")
public interface CollectionClient {

    @GetMapping(value = "/api/v1/wineries", headers = {""})
    List<Object> getWineries();

    @GetMapping(value = "/api/v1/wineries/{id}", headers = {""})
    Object getWineryById(@PathVariable("id") String id);

    @GetMapping(value = "/api/v1/wines", headers = {""})
    Object getWines(@RequestParam Optional<String> wineId, Optional<String> wineryId);
}
