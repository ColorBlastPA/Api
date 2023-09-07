package com.developer.colorblast.productBooking.service.impl;
import com.developer.colorblast.productBooking.entity.ProductBookingEntity;
import com.developer.colorblast.productBooking.repository.ProductBookingRepository;
import com.developer.colorblast.productBooking.service.ProductBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductBookingServiceImpl implements ProductBookingService {

    private final ProductBookingRepository productBookingRepository;

    @Autowired
    public ProductBookingServiceImpl(ProductBookingRepository productBookingRepository) {
        this.productBookingRepository = productBookingRepository;
    }

    @Override
    public ProductBookingEntity createProductBooking(ProductBookingEntity productBooking) {
        return productBookingRepository.save(productBooking);
    }

    @Override
    public ProductBookingEntity getProductBookingById(Long id) {
        Optional<ProductBookingEntity> productBookingOptional = productBookingRepository.findById(id);
        return productBookingOptional.orElse(null);
    }

    @Override
    public List<ProductBookingEntity> getAllProductBookings() {
        return productBookingRepository.findAll();
    }

    @Override
    public ProductBookingEntity updateProductBooking(Long id, ProductBookingEntity updatedProductBooking) {
        Optional<ProductBookingEntity> productBookingOptional = productBookingRepository.findById(id);
        if (productBookingOptional.isPresent()) {
            ProductBookingEntity existingProductBooking = productBookingOptional.get();
            // Mettez à jour les champs pertinents ici.
            existingProductBooking.setIdBooking(updatedProductBooking.getIdBooking());
            existingProductBooking.setIdProduct(updatedProductBooking.getIdProduct());
            // Mettez à jour d'autres champs si nécessaire.
            return productBookingRepository.save(existingProductBooking);
        } else {
            return null; // ProductBooking non trouvé.
        }
    }

    @Override
    public void deleteProductBooking(Long id) {
        productBookingRepository.deleteById(id);
    }

    @Override
    public List<ProductBookingEntity> getProductBookingsByBookingId(Long bookingId) {
        return productBookingRepository.findByIdBooking(bookingId);
    }
}

