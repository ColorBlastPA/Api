package com.developer.colorblast.quote.repository;

import com.developer.colorblast.quote.entity.QuoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuoteRepository extends JpaRepository<QuoteEntity, Long> {
    QuoteEntity findByIdBooking(Long bookingId);
}
