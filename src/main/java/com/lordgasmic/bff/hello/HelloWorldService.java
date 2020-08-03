package com.lordgasmic.bff.hello;

import com.lordgasmic.bff.comic.ComicClient;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    private final HelloWorldClient client;

    public HelloWorldService(final HelloWorldClient client){
        this.client = client;
    }

    public Object getHello(){
        return client.getHello();
    }
}
