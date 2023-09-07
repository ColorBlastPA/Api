package com.developer.colorblast.booking.entity;

import com.developer.colorblast.product.entity.ProductEntity;

import java.util.List;

public class BookingResponse {
    BookingEntity booking;
    List<ProductEntity> product;

    public BookingResponse(BookingEntity booking, List<ProductEntity> product) {
        this.booking = booking;
        this.product = product;
    }

    public BookingResponse() {

    }

    public BookingEntity getBooking() {
        return booking;
    }

    public void setBooking(BookingEntity booking) {
        this.booking = booking;
    }

    public List<ProductEntity> getProduct() {
        return product;
    }

    public void setProduct(List<ProductEntity> product) {
        this.product = product;
    }
}
