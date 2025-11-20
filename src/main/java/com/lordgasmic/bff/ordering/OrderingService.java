package com.lordgasmic.bff.ordering;

import com.google.gson.Gson;
import com.lordgasmic.bff.ordering.models.OrderingRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class OrderingService {

    @Value("${lordgasmic.rabbitmq.exchange}")
    private String exchange;

    @Value("${lordgasmic.rabbitmq.routingKey}")
    private String routingKey;

    private final AmqpTemplate amqpTemplate;
    private final Gson gson;

    public OrderingService(AmqpTemplate amqpTemplate,  Gson gson) {
        this.amqpTemplate = amqpTemplate;
        this.gson = gson;
    }

    public void send(final OrderingRequest request) {
        Message message = new Message(gson.toJson(request).getBytes(StandardCharsets.UTF_8));
        amqpTemplate.send(exchange, routingKey, message);
        log.info("LGC:d6d65ca6-88fe-4c06-9521-cfbf3e10d561 - Sent order");
    }
}
