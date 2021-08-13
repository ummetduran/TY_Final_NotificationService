package com.example.NotificationService.models;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserInfoStockDTO implements Serializable {
    List<NotifyTargetMessage> userList;
    private Long productId;
    private String messageType;
}
