package com.developer.colorblast.quote.service.impl;


import com.developer.colorblast.quote.entity.QuoteEntity;
import com.developer.colorblast.quote.repository.QuoteRepository;
import com.developer.colorblast.quote.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuoteServiceImpl implements QuoteService {

    private final QuoteRepository quoteRepository;

    @Autowired
    public QuoteServiceImpl(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @Override
    public QuoteEntity createQuote(QuoteEntity quote) {
        return quoteRepository.save(quote);
    }

    @Override
    public QuoteEntity getQuoteById(Long id) {
        Optional<QuoteEntity> quoteOptional = quoteRepository.findById(id);
        return quoteOptional.orElse(null);
    }

    @Override
    public List<QuoteEntity> getAllQuotes() {
        return quoteRepository.findAll();
    }

    @Override
    public QuoteEntity updateQuote(Long id, QuoteEntity updatedQuote) {
        Optional<QuoteEntity> quoteOptional = quoteRepository.findById(id);
        if (quoteOptional.isPresent()) {
            QuoteEntity existingQuote = quoteOptional.get();
            existingQuote.setIdBooking(updatedQuote.getIdBooking());
            existingQuote.setIdKey(updatedQuote.getIdKey());
            existingQuote.setFilename(updatedQuote.getFilename());
            return quoteRepository.save(existingQuote);
        } else {
            return null;
        }
    }

    @Override
    public void deleteQuote(Long id) {
        quoteRepository.deleteById(id);
    }

    @Override
    public QuoteEntity getQuotesByBookingId(Long bookingId) {
        return quoteRepository.findByIdBooking(bookingId);
    }
}

