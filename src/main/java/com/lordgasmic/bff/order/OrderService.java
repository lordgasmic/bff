package com.lordgasmic.bff.order;

import com.lordgasmic.bff.order.models.Item;
import com.lordgasmic.bff.order.models.OrderExtra;
import com.lordgasmic.bff.order.models.OrderRequest;
import com.lordgasmic.bff.order.models.OrderRequestOutbound;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        final Map<String, List<OrderExtra>> props = new HashMap<>();
        for (final Item item : request.getProperties()) {
            props.put(item.getItem(), item.getExtras());
        }
        outbound.setProperties(props);

        orderClient.putOrder(outbound);
    }

    public Object getOrders() {
        return orderClient.getOrders();
    }
}
