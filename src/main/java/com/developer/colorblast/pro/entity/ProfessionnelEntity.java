package com.developer.colorblast.pro.entity;

import javax.persistence.*;

@Entity
@Table(name = "professionnel")
public class ProfessionnelEntity {

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

    @Column(name = "company_name")
    private String company_name;

    @Column(name = "price")
    private Double price;

    @Column(name = "phone")
    private String phone;

    @Column(name = "note")
    private Integer note;

    @Column(name = "description")
    private String description;

    @Column(name = "id_certificate")
    private Long idCertificate;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "image")
    private String image;

    @Column(name = "waiting")
    private Boolean waiting;

    public ProfessionnelEntity() {
    }

    public ProfessionnelEntity(Long id, String lastname, String firstname, String mail, String password, String country, String department, String postal_code, String city, String company_name, Double price, String phone, Integer note, String description, Long idCertificate, String avatar,String image, Boolean waiting) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.mail = mail;
        this.password = password;
        this.country = country;
        this.department = department;
        this.postal_code = postal_code;
        this.city = city;
        this.company_name = company_name;
        this.price = price;
        this.phone = phone;
        this.note = note;
        this.description = description;
        this.idCertificate = idCertificate;
        this.avatar = avatar;
        this.image = image;
        this.waiting = waiting;
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

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getIdCertificate() {
        return idCertificate;
    }

    public void setIdCertificate(Long idCertificate) {
        this.idCertificate = idCertificate;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Boolean getWaiting() {
        return waiting;
    }

    public void setWaiting(Boolean waiting) {
        this.waiting = waiting;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

