package com.example.NotificationService.models;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class UserInfoListDTO implements Serializable {
    List<NotifyTargetMessage> userInfoList;
}
