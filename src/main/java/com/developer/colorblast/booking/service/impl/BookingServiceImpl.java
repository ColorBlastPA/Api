package com.developer.colorblast.booking.service.impl;

import com.developer.colorblast.booking.entity.BookingEntity;
import com.developer.colorblast.booking.repository.BookingRepository;
import com.developer.colorblast.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public BookingEntity createBooking(BookingEntity booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public BookingEntity getBookingById(Long id) {
        Optional<BookingEntity> booking = bookingRepository.findById(id);
        return booking.orElse(null);
    }

    @Override
    public List<BookingEntity> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public BookingEntity updateBooking(Long id, BookingEntity updatedBooking) {
        Optional<BookingEntity> bookingOptional = bookingRepository.findById(id);
        if (bookingOptional.isPresent()) {
            BookingEntity existingBooking = bookingOptional.get();

            existingBooking.setFirstname(updatedBooking.getFirstname());
            existingBooking.setLastname(updatedBooking.getLastname());
            existingBooking.setCity(updatedBooking.getCity());
            existingBooking.setAddress(updatedBooking.getAddress());
            existingBooking.setIdClient(updatedBooking.getIdClient());
            existingBooking.setIdPro(updatedBooking.getIdPro());
            existingBooking.setCategory(updatedBooking.getCategory());
            existingBooking.setSurface(updatedBooking.getSurface());
            existingBooking.setDhDebut(updatedBooking.getDhDebut());
            existingBooking.setDhFin(updatedBooking.getDhFin());
            existingBooking.setWaiting(updatedBooking.isWaiting());

            return bookingRepository.save(existingBooking);
        } else {
            return null;
        }
    }


    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public List<BookingEntity> getBookingsByClientIdAndNotWaiting(Long clientId) {
        return bookingRepository.findByClientIdAndWaitingFalse(clientId);
    }

    @Override
    public List<BookingEntity> getBookingsByClientIdAndWaiting(Long clientId) {
        return bookingRepository.findByClientIdAndWaitingTrue(clientId);
    }

    @Override
    public List<BookingEntity> getBookingsByProIdAndNotWaiting(Long idPro) {
        return bookingRepository.findByIdProAndWaitingFalse(idPro);
    }

    @Override
    public List<BookingEntity> getBookingsByProIdAndWaiting(Long idPro) {
        return bookingRepository.findByIdProAndWaitingTrue(idPro);
    }

}