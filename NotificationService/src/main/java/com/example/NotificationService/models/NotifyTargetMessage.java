package com.example.NotificationService.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotifyTargetMessage{
    private Long id;
    private String fullName;
    private String email;
}
