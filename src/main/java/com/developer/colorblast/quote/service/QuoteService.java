package com.developer.colorblast.quote.service;



import com.developer.colorblast.quote.entity.QuoteEntity;

import java.util.List;

public interface QuoteService {
    QuoteEntity createQuote(QuoteEntity quote);
    QuoteEntity getQuoteById(Long id);
    List<QuoteEntity> getAllQuotes();
    QuoteEntity updateQuote(Long id, QuoteEntity updatedQuote);
    void deleteQuote(Long id);
    QuoteEntity getQuotesByBookingId(Long bookingId);
}

