package com.lordgasmic.bff.collection;

import com.lordgasmic.bff.collection.model.WineRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class CollectionController {

    private final CollectionService service;

    public CollectionController(final CollectionService service) {
        this.service = service;
    }

    @GetMapping("/api/v1/wineries")
    public List<Object> getWineries() {
        return service.getWineries();
    }

    @GetMapping("/api/v1/wineries/{id}")
    public Object getWineryById(@PathVariable final String id) {
        return service.getWineryById(id);
    }

    @GetMapping("/api/v1/wines")
    public Object getWines(@RequestParam("wineId") final Optional<String> wineId, @RequestParam("wineryId") final Optional<String> wineryId) {
        return service.getWines(wineId.orElse(null), wineryId.orElse(null));
    }

    @PutMapping("/api/v1/wines")
    public Object addWine(@RequestBody final WineRequest wineRequest) {
        return service.addWine(wineRequest);
    }

    @GetMapping("/api/v1/wineNotes")
    public Object getWineNotes(@RequestParam("user") final Optional<String> user, @RequestParam("wineId") final Optional<Integer> wineId) {
        return service.getWineNotes(user.orElse(null), wineId.orElse(null));
    }

    @GetMapping("/api/v1/wineRating")
    public Object getWineRating(@RequestParam("user") final Optional<String> user, @RequestParam("wineId") final Optional<Integer> wineId) {
        return service.getWineRating(user.orElse(null), wineId.orElse(null));
    }
}
