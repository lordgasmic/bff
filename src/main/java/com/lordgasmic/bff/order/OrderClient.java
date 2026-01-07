package com.lordgasmic.bff.order;

import com.lordgasmic.bff.order.models.OrderRequestOutbound;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "order-client", url = "${order-service.url}")
public interface OrderClient {

    @PutMapping(value = "/api/v1/orders", headers = {""})
    Object putOrder(@RequestBody OrderRequestOutbound request);

    @GetMapping(value = "/api/v1/orders", headers = {""})
    Object getOrders();
}
