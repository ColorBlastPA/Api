package com.developer.colorblast.quote.controller;

import com.developer.colorblast.quote.entity.QuoteEntity;
import com.developer.colorblast.quote.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quotes")
public class QuoteController {

    private final QuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @PostMapping
    public QuoteEntity createQuote(@RequestBody QuoteEntity quote) {
        return quoteService.createQuote(quote);
    }

    @GetMapping("/{id}")
    public QuoteEntity getQuoteById(@PathVariable Long id) {
        return quoteService.getQuoteById(id);
    }

    @PutMapping("/{id}")
    public QuoteEntity updateQuote(@PathVariable Long id, @RequestBody QuoteEntity updatedQuote) {
        return quoteService.updateQuote(id, updatedQuote);
    }

    @DeleteMapping("/{id}")
    public void deleteQuote(@PathVariable Long id) {
        quoteService.deleteQuote(id);
    }

    @GetMapping("/booking/{bookingId}")
    public QuoteEntity getQuotesByBookingId(@PathVariable Long bookingId) {
        return quoteService.getQuotesByBookingId(bookingId);
    }
}

