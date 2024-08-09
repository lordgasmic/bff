package com.lordgasmic.bff.funko;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FunkoService {

    private FunkoClient client;

    public FunkoService(FunkoClient client) {
        this.client = client;
    }

    public Object getFunkos() {
        return client.getFunkos();
    }

    public Object index(){
        return client.index();
    }
}
