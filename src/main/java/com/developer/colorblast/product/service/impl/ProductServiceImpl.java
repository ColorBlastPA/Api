package com.developer.colorblast.product.service.impl;

import com.developer.colorblast.product.entity.ProductEntity;
import com.developer.colorblast.product.repository.ProductRepository;
import com.developer.colorblast.product.service.ProductService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductEntity> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<ProductEntity> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    @Override
    public ProductEntity updateProduct(ProductEntity productEntity) {
        if (!productRepository.existsById(productEntity.getId())) {
            throw new EntityNotFoundException("ProductEntity with ID " + productEntity.getId() + " not found");
        }
        return productRepository.save(productEntity);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}

