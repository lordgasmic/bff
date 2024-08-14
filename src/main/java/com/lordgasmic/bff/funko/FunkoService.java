package com.lordgasmic.bff.funko;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FunkoService {

    private FunkoClient client;

    public FunkoService(FunkoClient client) {
        this.client = client;
    }

    public Object getFunkos(int start, int count) {
        return client.getFunkos(start, count);
    }

    public Object index(){
        return client.index();
    }
}
