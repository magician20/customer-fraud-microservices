package com.magician.dev.amqp;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class RabbitMQConfig {

    private final ConnectionFactory connectionFactory;

    // Allow us to send messages to queues
    @Bean
    public AmqpTemplate amqpTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        // Producer take an object, convert to & send message as json
        // queue take json, convert to & send message as an object
        rabbitTemplate.setMessageConverter(jacksonConverter());
        return rabbitTemplate;
    }

//    @Bean
//    // we don't need below (done by default)
//    // allow us to receive the messages from queues
//    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory() {
//        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//        factory.setConnectionFactory(connectionFactory);
//        factory.setMessageConverter(jacksonConverter());
//
//        return factory;
//    }

    @Bean
    //used to create the converter Object To Json (ObjectMapper)
    public MessageConverter jacksonConverter() {
        // Jackson2ObjectMapperBuilder.json().modules()
        MessageConverter jackson2JsonMessageConverter = new Jackson2JsonMessageConverter();
        return jackson2JsonMessageConverter;
    }

}
