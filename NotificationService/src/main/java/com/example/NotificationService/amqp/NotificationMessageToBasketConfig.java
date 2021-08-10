package com.example.NotificationService.amqp;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationMessageToBasketConfig {

    @Value("${ns.rabbit.exchange.name}")
    String notificationExchangeName;

    @Value("${ns.rabbit.queue.name}")
    String notificationBasketsQueueName;

    @Value("${ns.rabbit.routing.name}")
    String productPriceChangeNotificationRoutingKey;

    @Bean
    public DirectExchange notificationExchange() {
        return new DirectExchange(notificationExchangeName);
    }

    @Bean
    public Queue notificationSubscribersQueue() {
        return new Queue(notificationBasketsQueueName, true);
    }

    @Bean
    public Binding notificationSubscribersBinding(DirectExchange notificationExchange,
                                                  Queue notificationSubscribersQueue) {
        return BindingBuilder.bind(notificationSubscribersQueue)
                .to(notificationExchange)
                .with(productPriceChangeNotificationRoutingKey);
    }
}
