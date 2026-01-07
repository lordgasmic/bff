package com.lordgasmic.bff.order;

import com.lordgasmic.bff.configuration.LordgasmicConstants;
import com.lordgasmic.bff.order.models.OrderRequest;
import com.lordgasmic.bff.session.SessionManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    private final SessionManager sessionManager;
    private final OrderService service;

    public OrderController(final SessionManager sessionManager, final OrderService service) {
        this.sessionManager = sessionManager;
        this.service = service;
    }

    @PutMapping("/api/v1/orders")
    public ResponseEntity<Void> send(@RequestHeader(LordgasmicConstants.LORDGASMIC_AUTH_TOKEN) final String token,
                                     @RequestBody final OrderRequest orderingRequest) {
        final String user = sessionManager.getSessionDetails(token).getUsername();

        service.putOrder(user, orderingRequest);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/api/v1/orders")
    public ResponseEntity<Object> getOrders() {
        return ResponseEntity.ok(service.getOrders());
    }
}
