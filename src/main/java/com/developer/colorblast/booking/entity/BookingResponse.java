package com.developer.colorblast.booking.entity;

import com.developer.colorblast.product.entity.ProductEntity;
import com.developer.colorblast.quote.entity.QuoteEntity;

import javax.annotation.Nullable;
import java.util.List;

public class BookingResponse {
    BookingEntity booking;
    List<ProductEntity> product;
    @Nullable
    QuoteEntity quote;

    public BookingResponse(BookingEntity booking, List<ProductEntity> product, QuoteEntity quote) {
        this.booking = booking;
        this.product = product;
        this.quote = quote;
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

    public QuoteEntity getQuote() {
        return quote;
    }

    public void setQuote(QuoteEntity quote) {
        this.quote = quote;
    }
}
