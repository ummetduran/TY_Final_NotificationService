package com.example.NotificationService.amqp;

import com.example.NotificationService.models.ProductPriceChangeMessage;
import com.example.NotificationService.models.entity.Notification;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class NotificationPublisherToBasket {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${ns.rabbit.exchange.name}")
    private String notificationExchange;

    @Value("${ns.rabbit.routing.name}")
    private String productPriceChangeNotificationRoutingKey;

    public void publishNotificationMessage(ProductPriceChangeMessage priceChangeMessage){
        var message = new ProductPriceChangeMessage();

        message.setProductId(priceChangeMessage.getProductId());
        message.setProductName(priceChangeMessage.getProductName());
        message.setOldPrice(priceChangeMessage.getOldPrice());
        message.setNewPrice(priceChangeMessage.getNewPrice());
        System.out.println("*****"+message);
        rabbitTemplate.convertAndSend(notificationExchange, productPriceChangeNotificationRoutingKey, message);
        System.out.println("Sended" +message);

    }
}
