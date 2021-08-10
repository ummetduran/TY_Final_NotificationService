package com.example.NotificationService.amqp;

import com.example.NotificationService.models.NotifyTargetMessage;
import com.example.NotificationService.models.UserInfoListDTO;
import com.example.NotificationService.services.NotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotifyTargetListener {

    private NotificationService notificationService;

    public NotifyTargetListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RabbitListener(queues = "${ns.rabbit.queues.notify-target}")
    public void notifyTargetListener(UserInfoListDTO message) {
notificationService.notifyTarget(message);
    }
    }
