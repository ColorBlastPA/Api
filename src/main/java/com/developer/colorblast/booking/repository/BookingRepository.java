package com.developer.colorblast.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.developer.colorblast.booking.entity.BookingEntity;

import java.util.List;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
    List<BookingEntity> findByClientIdAndWaitingFalse(Long clientId);
    List<BookingEntity> findByClientIdAndWaitingTrue(Long clientId);
    List<BookingEntity> findByIdProAndWaitingFalse(Long idPro);

    List<BookingEntity> findByIdProAndWaitingTrue(Long idPro);
}
