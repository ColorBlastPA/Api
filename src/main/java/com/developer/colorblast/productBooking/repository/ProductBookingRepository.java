package com.developer.colorblast.productBooking.repository;

import com.developer.colorblast.productBooking.entity.ProductBookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductBookingRepository extends JpaRepository<ProductBookingEntity, Long> {
    List<ProductBookingEntity> findByIdBooking(Long bookingId);
}
