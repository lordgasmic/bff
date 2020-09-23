package com.lordgasmic.bff.feeding;

import com.lordgasmic.bff.feeding.model.FeedRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
public class FeedingController {

    private final FeedingService service;

    public FeedingController(final FeedingService service){
        this.service = service;
    }

    @PutMapping("/api/v2/feed")
    public Object putFeed(@RequestBody FeedRequest request){
        return service.putFeed(request);
    }

    @PutMapping("/api/v2/feeds")
    public Object putFeeds(@RequestBody List<FeedRequest> requests){
        return service.putFeeds(requests);
    }
}