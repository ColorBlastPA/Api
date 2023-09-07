package com.developer.colorblast.productBooking.entity;

import javax.persistence.*;

@Entity
@Table(name = "product_booking")
public class ProductBookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_booking")
    private Long idBooking;

    @Column(name = "id_product")
    private Long idProduct;

    public ProductBookingEntity() {
    }

    public ProductBookingEntity(Long idBooking, Long idProduct) {
        this.idBooking = idBooking;
        this.idProduct = idProduct;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(Long idBooking) {
        this.idBooking = idBooking;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }
}

