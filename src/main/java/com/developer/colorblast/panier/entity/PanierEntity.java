package com.developer.colorblast.panier.entity;

import javax.persistence.*;

@Entity
@Table(name = "panier")
public class PanierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_client")
    private Long idClient;

    @Column(name = "id_product")
    private Long idProduct;

    public PanierEntity() {
    }

    public PanierEntity(Long id, Long idClient, Long idProduct) {
        this.id = id;
        this.idClient = idClient;
        this.idProduct = idProduct;
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

