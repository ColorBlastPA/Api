package com.developer.colorblast.order.entity;

import com.developer.colorblast.product.entity.ProductEntity;

import java.util.List;

public class OderData {

    private String idKey;
    private Long idClient;
    private List<ProductEntity> product;

    public OderData(String idKey, Long idClient, List<ProductEntity> product) {
        this.idKey = idKey;
        this.idClient = idClient;
        this.product = product;
    }

    public OderData() {

    }

    public String getIdKey() {
        return idKey;
    }

    public void setIdKey(String idKey) {
        this.idKey = idKey;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public List<ProductEntity> getProduct() {
        return product;
    }

    public void setProduct(List<ProductEntity> product) {
        this.product = product;
    }
}
