package com.developer.colorblast.booking.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "booking")
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "id_pro")
    private Long idPro;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "category")
    private int category;

    @Column(name = "surface")
    private float surface;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dh_debut")
    private Date dhDebut;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dh_fin")
    private Date dhFin;

    @Column(name = "waiting")
    private boolean waiting;

    public BookingEntity() {
    }

    public BookingEntity(Long id, Long idClient, Long idPro, String lastname, String firstname, String city, String address, int category, float surface, Date dhDebut, Date dhFin, boolean waiting) {
        this.id = id;
        this.clientId = idClient;
        this.idPro = idPro;
        this.lastname = lastname;
        this.firstname = firstname;
        this.city = city;
        this.address = address;
        this.category = category;
        this.surface = surface;
        this.dhDebut = dhDebut;
        this.dhFin = dhFin;
        this.waiting = waiting;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdClient() {
        return clientId;
    }

    public void setIdClient(Long idClient) {
        this.clientId = idClient;
    }

    public Long getIdPro() {
        return idPro;
    }

    public void setIdPro(Long idPro) {
        this.idPro = idPro;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public float getSurface() {
        return surface;
    }

    public void setSurface(float surface) {
        this.surface = surface;
    }

    public Date getDhDebut() {
        return dhDebut;
    }

    public void setDhDebut(Date dhDebut) {
        this.dhDebut = dhDebut;
    }

    public Date getDhFin() {
        return dhFin;
    }

    public void setDhFin(Date dhFin) {
        this.dhFin = dhFin;
    }

    public boolean isWaiting() {
        return waiting;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }
}

