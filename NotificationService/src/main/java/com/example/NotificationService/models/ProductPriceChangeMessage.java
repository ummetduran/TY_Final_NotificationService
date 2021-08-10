package com.example.NotificationService.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductPriceChangeMessage implements Serializable {


    private Long productId;
    private Double oldPrice;

    private Double newPrice;

    @Override
    public String toString() {
        return "ProductPriceChangeMessage{" +
                ", productId=" + productId +
                ", oldPrice=" + oldPrice +
                ", newPrice=" + newPrice +
                '}';
    }
}
