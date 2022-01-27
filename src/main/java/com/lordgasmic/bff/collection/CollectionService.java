package com.lordgasmic.bff.collection;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollectionService {

    private final CollectionClient client;

    public CollectionService(final CollectionClient client) {
        this.client = client;
    }

    public List<Object> getWineries() {
        return client.getWineries();
    }

    public Object getWineryById(final String id) {
        return client.getWineryById(id);
    }

    public Object getWines(final Optional<String> wineId, final Optional<String> wineryId) {
        return client.getWines(wineId, wineryId);
    }
}
