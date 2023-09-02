package com.developer.colorblast.client.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "client")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "mail")
    private String mail;

    @Column(name = "password")
    private String password;
    @Column(name = "country")
    private String country;
    @Column(name = "department")
    private String department;
    @Column(name = "postal_code")
    private String postal_code;
    @Column(name = "city")
    private String city;
    @Column(name = "address")
    private String address;

    @Column(name = "avatar")
    private String avatar;


    public ClientEntity() {
    }


    public ClientEntity(Long id, String lastname, String firstname, String mail, String password, String country, String department, String postal_code, String city, String address, String avatar) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.mail = mail;
        this.password = password;
        this.country = country;
        this.department = department;
        this.postal_code = postal_code;
        this.city = city;
        this.address = address;
        this.avatar = avatar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
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


    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
