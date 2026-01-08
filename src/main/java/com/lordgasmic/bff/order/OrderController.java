package com.lordgasmic.bff.order;

import com.lordgasmic.bff.configuration.LordgasmicConstants;
import com.lordgasmic.bff.order.models.OrderRequest;
import com.lordgasmic.bff.session.SessionManager;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController {

    private final SessionManager sessionManager;
    private final OrderService service;
    private final MeterRegistry meterRegistry;

    public OrderController(final SessionManager sessionManager, final OrderService service, final MeterRegistry meterRegistry) {
        this.sessionManager = sessionManager;
        this.service = service;
        this.meterRegistry = meterRegistry;
    }

    @PutMapping("/api/v1/orders")
    public ResponseEntity<Void> send(@RequestHeader(LordgasmicConstants.LORDGASMIC_AUTH_TOKEN) final String token,
                                     @RequestBody final OrderRequest orderingRequest) {

        final String user;
        try {
            user = meterRegistry.timer("bff.order.get-username").recordCallable(() -> sessionManager.getSessionDetails(token).getUsername());
        } catch (final Exception e) {
            log.error("LGC-4007547a-472f-4ee0-b7d3-4fcc38d434e1: Unable to get username from session manager", e);
            throw new RuntimeException(e);
        }

        meterRegistry.timer("bff.order.put-order").record(() -> service.putOrder(user, orderingRequest));

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/api/v1/orders")
    public ResponseEntity<Object> getOrders() {
        return ResponseEntity.ok(service.getOrders());
    }
}
