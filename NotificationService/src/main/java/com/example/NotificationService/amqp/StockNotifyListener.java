package com.example.NotificationService.amqp;

import com.example.NotificationService.models.UserInfoStockDTO;
import com.example.NotificationService.services.NotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class StockNotifyListener {
    private final NotificationService notificationService;

    public StockNotifyListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RabbitListener(queues = "${ns.rabbit.queues.stock-notify}")
    public void listenStockNotify(UserInfoStockDTO userInfoStockDTO){
        System.out.println(userInfoStockDTO);
        notificationService.createStockNotification(userInfoStockDTO);
    }
}
