package com.developer.colorblast.productBooking.service;

import com.developer.colorblast.productBooking.entity.ProductBookingEntity;

import java.util.List;

public interface ProductBookingService {
    ProductBookingEntity createProductBooking(ProductBookingEntity productBooking);
    ProductBookingEntity getProductBookingById(Long id);
    List<ProductBookingEntity> getAllProductBookings();
    ProductBookingEntity updateProductBooking(Long id, ProductBookingEntity updatedProductBooking);
    void deleteProductBooking(Long id);
    List<ProductBookingEntity> getProductBookingsByBookingId(Long bookingId);
}

