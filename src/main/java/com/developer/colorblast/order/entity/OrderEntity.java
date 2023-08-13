package com.developer.colorblast.order.entity;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "clef", columnDefinition = "VARCHAR(36)")
    private String idKey;

    @Column(name = "id_client")
    private Long idClient;

    @Column(name = "id_product")
    private Long idProduct;

    public OrderEntity(Long id, String idKey, Long idClient, Long idProduct) {
        this.id = id;
        this.idKey = idKey;
        this.idClient = idClient;
        this.idProduct = idProduct;
    }

    public OrderEntity() {

    }

    public String getIdKey() {
        return idKey;
    }

    public void setIdKey(String idKey) {
        this.idKey = idKey;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }
}

