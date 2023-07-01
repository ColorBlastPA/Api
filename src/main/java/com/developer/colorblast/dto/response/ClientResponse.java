package com.developer.colorblast.dto.response;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

public class ClientResponse implements Serializable {
    private Long id;



    private String lastname;

    private String firstname;
    private String mail;

    private String password;

    private String country;

    private String department;

    private String postal_code;

    private String city;

    private String address;

    private Boolean is_admin;

    public Long getId() {
        return id;
    }

    public ClientResponse() {
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

    public Boolean getAdmin() {
        return is_admin;
    }

    public void setAdmin(Boolean admin) {
        is_admin = admin;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isAdmin() {
        return is_admin;
    }

    public void setAdmin(boolean admin) {
        is_admin = admin;
    }
}
