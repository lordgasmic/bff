package com.lordgasmic.bff.ordering;

import com.lordgasmic.bff.ordering.models.OrderingRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderingController {

    private final OrderingService service;

    public OrderingController(OrderingService service) {
        this.service = service;
    }

    @PostMapping("/api/v1/ordering")
    public ResponseEntity<Void> send(@RequestBody OrderingRequest orderingRequest) {
        service.send(orderingRequest);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
