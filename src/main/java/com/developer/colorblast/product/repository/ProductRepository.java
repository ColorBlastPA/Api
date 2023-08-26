package com.developer.colorblast.product.repository;

import com.developer.colorblast.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByCategoryIn(List<ProductEntity.Category> categories);
}
