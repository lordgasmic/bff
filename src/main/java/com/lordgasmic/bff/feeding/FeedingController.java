package com.lordgasmic.bff.feeding;

import com.lordgasmic.bff.models.FeedRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class FeedingController {

    private final com.lordgasmic.bff.feeding.FeedingService service;

    public FeedingController(final com.lordgasmic.bff.feeding.FeedingService service){
        this.service = service;
    }

    @PutMapping("/api/v1/feed")
    public Object get(@RequestBody FeedRequest request){
        return service.putFeed(request);
    }
}