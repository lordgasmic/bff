package com.lordgasmic.bff.order;

import com.lordgasmic.bff.order.models.Item;
import com.lordgasmic.bff.order.models.OrderExtra;
import com.lordgasmic.bff.order.models.OrderRequest;
import com.lordgasmic.bff.order.models.OrderRequestOutbound;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
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

        log.info("LGC-1ff4fdfe-dee5-4a59-91cd-49642c637a9a: outbound: {}", outbound);
        orderClient.putOrder(outbound);
    }

    public Object getOrders() {
        return orderClient.getOrders();
    }
}
