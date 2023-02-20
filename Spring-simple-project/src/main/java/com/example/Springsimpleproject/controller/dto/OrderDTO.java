package com.example.Springsimpleproject.controller.dto;

import com.example.Springsimpleproject.model.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private String productName;
    private Long price;

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.productName = order.getProductName();
        this.price = order.getPrice();
    }
}
