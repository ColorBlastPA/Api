package com.developer.colorblast.booking.controller;

import com.developer.colorblast.booking.entity.BookingEntity;
import com.developer.colorblast.booking.entity.BookingResponse;
import com.developer.colorblast.booking.service.BookingService;
import com.developer.colorblast.product.entity.ProductEntity;
import com.developer.colorblast.product.service.ProductService;
import com.developer.colorblast.productBooking.entity.ProductBookingEntity;
import com.developer.colorblast.productBooking.service.ProductBookingService;
import com.developer.colorblast.quote.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    private final ProductBookingService productBookingService;

    private final ProductService productService;

    private final QuoteService quoteService;

    @Autowired
    public BookingController(BookingService bookingService, ProductBookingService productBookingService, ProductService productService, QuoteService quoteService) {
        this.bookingService = bookingService;
        this.productBookingService = productBookingService;
        this.productService = productService;
        this.quoteService = quoteService;
    }

    @PostMapping
    public BookingEntity createBooking(@RequestBody BookingEntity booking) {
        return bookingService.createBooking(booking);
    }

    @GetMapping("/{id}")
    public BookingEntity getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    @GetMapping
    public List<BookingEntity> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @PutMapping("/{id}")
    public BookingEntity updateBooking(@PathVariable Long id, @RequestBody BookingEntity updatedBooking) {
        return bookingService.updateBooking(id, updatedBooking);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }

    @GetMapping("/client/{clientId}/notwaiting")
    public List<BookingResponse> getBookingsByClientIdAndNotWaiting(@PathVariable Long clientId) {
        List<BookingEntity> bookings = bookingService.getBookingsByClientIdAndNotWaiting(clientId);
        List<BookingResponse> responses = new ArrayList<>();

        for (BookingEntity booking : bookings) {
            List<ProductBookingEntity> productBookings = productBookingService.getProductBookingsByBookingId(booking.getId());
            List<ProductEntity> products = new ArrayList<>();

            for (ProductBookingEntity productBooking : productBookings) {
                Optional<ProductEntity> product = productService.findById(productBooking.getIdProduct());
                product.ifPresent(products::add);
            }

            BookingResponse response = new BookingResponse();
            response.setBooking(booking);
            response.setProduct(products);
            response.setQuote(quoteService.getQuotesByBookingId(booking.getId()));

            responses.add(response);
        }

        return responses;
    }


    @GetMapping("/pro/{idPro}/notwaiting")
    public List<BookingResponse> getBookingsByProIdAndNotWaiting(@PathVariable Long idPro) {
        List<BookingEntity> bookings = bookingService.getBookingsByProIdAndNotWaiting(idPro);
        List<BookingResponse> responses = new ArrayList<>();

        for (BookingEntity booking : bookings) {
            List<ProductBookingEntity> productBookings = productBookingService.getProductBookingsByBookingId(booking.getId());
            List<ProductEntity> products = new ArrayList<>();

            for (ProductBookingEntity productBooking : productBookings) {
                Optional<ProductEntity> product = productService.findById(productBooking.getIdProduct());
                product.ifPresent(products::add);
            }

            BookingResponse response = new BookingResponse();
            response.setBooking(booking);
            response.setProduct(products);
            response.setQuote(quoteService.getQuotesByBookingId(booking.getId()));

            responses.add(response);
        }

        return responses;
    }

    @GetMapping("/pro/{idPro}/waiting")
    public List<BookingResponse> getBookingsByProIdAndWaiting(@PathVariable Long idPro) {
        List<BookingEntity> bookings = bookingService.getBookingsByProIdAndWaiting(idPro);
        List<BookingResponse> responses = new ArrayList<>();

        for (BookingEntity booking : bookings) {
            List<ProductBookingEntity> productBookings = productBookingService.getProductBookingsByBookingId(booking.getId());
            List<ProductEntity> products = new ArrayList<>();

            for (ProductBookingEntity productBooking : productBookings) {
                Optional<ProductEntity> product = productService.findById(productBooking.getIdProduct());
                product.ifPresent(products::add);
            }

            BookingResponse response = new BookingResponse();
            response.setBooking(booking);
            response.setProduct(products);
            response.setQuote(quoteService.getQuotesByBookingId(booking.getId()));

            responses.add(response);
        }

        return responses;
    }

}
