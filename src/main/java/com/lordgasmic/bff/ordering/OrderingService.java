package com.lordgasmic.bff.ordering;

import com.lordgasmic.bff.ordering.models.OrderingRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderingService {

    @Value("${lordgasmic.rabbitmq.exchange}")
    private String exchange;

    @Value("${lordgasmic.rabbitmq.routingKey}")
    private String routingKey;

    private final AmqpTemplate rabbitTemplate;

    public OrderingService(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(final OrderingRequest request) {
        rabbitTemplate.convertAndSend(exchange, routingKey, request);
        log.info("LGC:d6d65ca6-88fe-4c06-9521-cfbf3e10d561 - Sent order");
    }
}