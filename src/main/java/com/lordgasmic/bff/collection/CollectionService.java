package com.lordgasmic.bff.collection;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionService {

    private final CollectionClient client;

    public CollectionService(final CollectionClient client) {
        this.client = client;
    }

    public List<Object> getWineries() {
        return client.getWineries();
    }
}
