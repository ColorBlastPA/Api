package com.developer.colorblast.order.service.impl;

import com.developer.colorblast.order.entity.OrderEntity;
import com.developer.colorblast.order.repository.OrdersRepository;
import com.developer.colorblast.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    private final OrdersRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrdersRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public OrderEntity getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public OrderEntity createOrder(OrderEntity order) {
        return orderRepository.save(order);
    }

    @Override
    public OrderEntity updateOrder(Long id, OrderEntity updatedOrder) {
        if (orderRepository.existsById(id)) {
            updatedOrder.setId(id);
            return orderRepository.save(updatedOrder);
        }
        return null;
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
    @Override
    public List<OrderEntity> getOrdersByIdKey(String idKey) {
        return orderRepository.findByIdKey(idKey);
    }
}
