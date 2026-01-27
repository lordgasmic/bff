package com.lordgasmic.bff.funko;

import org.springframework.stereotype.Service;

@Service
public class FunkoService {

    private final FunkoClient client;

    public FunkoService(final FunkoClient client) {
        this.client = client;
    }

    public Object getFunkos(final int start, final int count) {
        return client.getFunkos(start, count);
    }

    public Object getFunkoById(final String id) {
        return client.getFunkoById(id);
    }

    public void addFunko(final FunkoRequest request) {
        client.addFunko(request);
    }
}
