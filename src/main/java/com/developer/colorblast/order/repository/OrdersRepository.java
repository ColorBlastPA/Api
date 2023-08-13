package com.developer.colorblast.order.repository;

import com.developer.colorblast.order.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findByIdKey(String idKey);
}
