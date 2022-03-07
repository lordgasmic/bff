package com.lordgasmic.bff.collection;

import com.lordgasmic.bff.collection.model.WineRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "collection-client", url = "${collection-service.url}")
public interface CollectionClient {

    @GetMapping(value = "/api/v1/wineries", headers = {""})
    List<Object> getWineries();

    @GetMapping(value = "/api/v1/wineries/{id}", headers = {""})
    Object getWineryById(@PathVariable("id") String id);

    @GetMapping(value = "/api/v1/wines", headers = {""})
    Object getWines(@RequestParam("wineId") String wineId, @RequestParam("wineryId") String wineryId);

    @GetMapping(value = "/api/v1/wineNotes", headers = {""})
    Object getWineNotes(@RequestParam("user") String user, @RequestParam("wineId") Integer wineID);

    @GetMapping(value = "/api/v1/wineRating", headers = {""})
    Object getWineRating(@RequestParam("user") String user, @RequestParam("wineId") Integer wineId);

    @PutMapping(value = "/api/v1/wines", headers = {""})
    Object addWine(@RequestBody WineRequest wineRequest);
}
