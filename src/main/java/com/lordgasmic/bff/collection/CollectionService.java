package com.lordgasmic.bff.collection;

import com.lordgasmic.bff.collection.model.GasRequest;
import org.springframework.stereotype.Service;

@Service
public class CollectionService {

    private final CollectionClient client;

    public CollectionService(final CollectionClient client) {
        this.client = client;
    }

    public Object addGas(final GasRequest request) {
        return client.addGas(request);
    }

    public Object getGas(final String vehicle) {
        return client.getGas(vehicle);
    }
}
