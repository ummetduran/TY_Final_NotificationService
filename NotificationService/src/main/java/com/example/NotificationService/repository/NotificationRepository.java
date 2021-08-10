package com.example.NotificationService.repository;

import com.example.NotificationService.models.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
