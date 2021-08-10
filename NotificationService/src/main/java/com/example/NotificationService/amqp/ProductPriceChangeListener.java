package com.example.NotificationService.amqp;


import com.example.NotificationService.models.ProductServiceMessageWrapper;
import com.example.NotificationService.services.NotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ProductPriceChangeListener {
    private final NotificationService notificationService;

    public ProductPriceChangeListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    @RabbitListener(queues = "${ns.rabbit.queues.product-price-change}")
    public void productPriceChangeListener(ProductServiceMessageWrapper message){
        System.out.println("message is "+ message.getMessage());
        notificationService.createProductPriceChangeNotification(message.getMessage());
    }
}
