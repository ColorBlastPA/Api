package com.developer.colorblast.order.service;

import com.developer.colorblast.order.entity.OrderEntity;

import java.util.List;

public interface OrderService {
    List<OrderEntity> getAllOrders();
    OrderEntity getOrderById(Long id);
    OrderEntity createOrder(OrderEntity order);
    OrderEntity updateOrder(Long id, OrderEntity order);
    void deleteOrder(Long id);
    List<OrderEntity> getOrdersByIdKey(String idKey);
}

