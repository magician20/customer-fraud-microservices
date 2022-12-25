package com.magician.dev.amqp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class RabbitMQMessageProducer {

    private final AmqpTemplate amqpTemplate;

    // allow us to publish to queue by passing exchange name
    public void publish(Object payload,String exchange,String routingKey ){
        log.info("Publishing to {} using routingKey {}. Payload: {}",exchange,routingKey,payload);
        amqpTemplate.convertAndSend(exchange,routingKey,payload);
        log.info("Publishing to {} using routingKey {}. Payload: {}",exchange,routingKey,payload);

    }

}
