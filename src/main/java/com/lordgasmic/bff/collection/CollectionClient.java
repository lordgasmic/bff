package com.lordgasmic.bff.collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "collection-client", url = "${collection-service.url}")
public interface CollectionClient {

    @GetMapping(value = "/api/v1/wineries", headers = {""})
    List<Object> getWineries();

    @GetMapping(value = "/api/v1/wineries/{id}", headers = {""})
    Object getWineryById(@PathVariable("id") String id);
}
