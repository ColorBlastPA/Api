package com.developer.colorblast.panier.dto;

import com.developer.colorblast.product.entity.ProductEntity;

public class PanierData {
    Long idPanier;
    ProductEntity product;

    public PanierData(Long idPanier, ProductEntity product) {
        this.idPanier = idPanier;
        this.product = product;
    }

    public Long getIdPanier() {
        return idPanier;
    }

    public void setIdPanier(Long idPanier) {
        this.idPanier = idPanier;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}
