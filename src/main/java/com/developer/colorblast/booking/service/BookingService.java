package com.developer.colorblast.booking.service;

import com.developer.colorblast.booking.entity.BookingEntity;

import java.util.List;

public interface BookingService {
    BookingEntity createBooking(BookingEntity booking);
    BookingEntity getBookingById(Long id);
    List<BookingEntity> getAllBookings();
    BookingEntity updateBooking(Long id, BookingEntity booking);
    void deleteBooking(Long id);
    List<BookingEntity> getBookingsByClientIdAndNotWaiting(Long clientId);
    List<BookingEntity> getBookingsByProIdAndNotWaiting(Long idPro);
    List<BookingEntity> getBookingsByProIdAndWaiting(Long idPro);
}
