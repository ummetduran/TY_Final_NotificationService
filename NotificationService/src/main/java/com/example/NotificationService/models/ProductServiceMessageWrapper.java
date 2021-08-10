package com.example.NotificationService.models;

import lombok.Data;

import java.io.Serializable;
@Data
public class ProductServiceMessageWrapper implements Serializable {
    ProductPriceChangeMessage message;
}
