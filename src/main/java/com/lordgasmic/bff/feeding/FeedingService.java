package com.lordgasmic.bff.feeding;

import com.lordgasmic.bff.models.FeedRequest;
import org.springframework.stereotype.Service;

@Service
public class FeedingService {

    private final FeedingClient client;

    public FeedingService(final FeedingClient client){
        this.client = client;
    }

    public Object putFeed(FeedRequest request){
        return client.putFeed(request);
    }
}
