package com.example.NotificationService.services;

import com.example.NotificationService.amqp.NotificationPublisherToBasket;
import com.example.NotificationService.models.NotifyTargetMessage;
import com.example.NotificationService.models.ProductPriceChangeMessage;
import com.example.NotificationService.models.UserInfoListDTO;
import com.example.NotificationService.models.entity.Notification;
import com.example.NotificationService.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.lang.module.FindException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

@Service
public class NotificationService {
    private static Long productId;
    private final NotificationRepository notificationRepository;

    private final NotificationPublisherToBasket notificationPublisherToBasket;


    public NotificationService(NotificationRepository notificationRepository, NotificationPublisherToBasket notificationPublisherToBasket) {
        this.notificationRepository = notificationRepository;
        this.notificationPublisherToBasket = notificationPublisherToBasket;
    }

    public void createProductPriceChangeNotification(ProductPriceChangeMessage productPriceChangeMessage){
//        Notification notification = productPriceChangeToNotification(productPriceChangeMessage);
//        System.out.println("////////////"+notification);
//        Notification notificationRecord =notificationRepository.save(notification);
        productId = productPriceChangeMessage.getProductId();
        notificationPublisherToBasket.publishNotificationMessage(productPriceChangeMessage);

    }

    private Notification productPriceChangeToNotification(ProductPriceChangeMessage productPriceChangeMessage) {
        Notification notification = new Notification();
        System.out.println(productPriceChangeMessage);
        notification.setProductId(productPriceChangeMessage.getProductId());
        notification.setNewPrice(productPriceChangeMessage.getNewPrice());
        notification.setOldPrice(productPriceChangeMessage.getOldPrice());
        return notification;

    }

    public void notifyTarget(UserInfoListDTO message){
        List<NotifyTargetMessage> userList = new ArrayList<>();
        for (NotifyTargetMessage user: message.getUserInfoList()){
            userList.add(user);
            sendNotificationToTarget(user);
        }
    }

    private void sendNotificationToTarget(NotifyTargetMessage user) {
        System.out.println("Sevgili "+user.getFullName() +" sepetinizdeki "+productId+ "idli ürünün fiyatı azaldı."+"to "+  user.getEmail());
    }
}
