package com.lordgasmic.bff.order;

import com.lordgasmic.bff.order.models.OrderRequest;
import com.lordgasmic.bff.order.models.OrderRequestOutbound;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderClient orderClient;

    public OrderService(final OrderClient orderClient) {
        this.orderClient = orderClient;
    }

    public void putOrder(final String user, final OrderRequest request) {
        final OrderRequestOutbound outbound = new OrderRequestOutbound();
        outbound.setUser(user);
        outbound.setMessage(request.getMessage());
        outbound.setType(request.getType());
        outbound.setProperties(request.getProperties());
        orderClient.putOrder(outbound);
    }

    public Object getOrders() {
        return orderClient.getOrders();
    }
}
