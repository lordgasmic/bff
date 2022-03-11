package com.lordgasmic.bff.collection;

import com.lordgasmic.bff.collection.model.WineFriendsRequest;
import com.lordgasmic.bff.collection.model.WineNoteRequest;
import com.lordgasmic.bff.collection.model.WineRatingRequest;
import com.lordgasmic.bff.collection.model.WineRequest;
import com.lordgasmic.bff.collection.model.WineryRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

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

    @PutMapping(value = "/api/v1/wineries", headers = {""})
    Object addWinery(@RequestBody WineryRequest wineryRequest);

    @PutMapping(value = "/api/v1/wineNotes", headers = {""})
    Object addWineNotes(@RequestBody List<WineNoteRequest> wineNoteRequests);

    @PutMapping(value = "/api/v1/wineRating", headers = {""})
    Object addWineRating(@RequestBody WineRatingRequest request);

    @PostMapping(value = "/api/v1/wineRating", headers = {""})
    Object getWineRatingByUsersByWineId(@RequestBody WineFriendsRequest request);

    @PutMapping(value = "/api/v1/wineImages", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Object addWineImage(@RequestHeader Map<String, String> headers, @RequestPart("imageFile") MultipartFile imageFile);

    @GetMapping(value = "/api/v1/wineImages", headers = {""})
    Object getWineImages(@RequestParam("wineId") int wineId);
}
