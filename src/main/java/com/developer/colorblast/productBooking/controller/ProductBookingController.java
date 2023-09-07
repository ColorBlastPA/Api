package com.developer.colorblast.productBooking.controller;

import com.developer.colorblast.productBooking.entity.ProductBookingEntity;
import com.developer.colorblast.productBooking.service.ProductBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productbookings")
public class ProductBookingController {

    private final ProductBookingService productBookingService;

    @Autowired
    public ProductBookingController(ProductBookingService productBookingService) {
        this.productBookingService = productBookingService;
    }

    @PostMapping
    public ProductBookingEntity createProductBooking(@RequestBody ProductBookingEntity productBooking) {
        return productBookingService.createProductBooking(productBooking);
    }

    @GetMapping("/{id}")
    public ProductBookingEntity getProductBookingById(@PathVariable Long id) {
        return productBookingService.getProductBookingById(id);
    }

    @PutMapping("/{id}")
    public ProductBookingEntity updateProductBooking(@PathVariable Long id, @RequestBody ProductBookingEntity updatedProductBooking) {
        return productBookingService.updateProductBooking(id, updatedProductBooking);
    }

    @DeleteMapping("/{id}")
    public void deleteProductBooking(@PathVariable Long id) {
        productBookingService.deleteProductBooking(id);
    }
    @GetMapping("/booking/{bookingId}")
    public List<ProductBookingEntity> getProductBookingsByBookingId(@PathVariable Long bookingId) {
        return productBookingService.getProductBookingsByBookingId(bookingId);
    }
}

