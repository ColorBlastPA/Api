package com.developer.colorblast.quote.entity;


import javax.persistence.*;

@Entity
@Table(name = "quote")
public class QuoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_booking")
    private Long idBooking;

    @Column(name = "clef", columnDefinition = "VARCHAR(36)")
    private String idKey;

    @Column(name = "filename")
    private String filename;

    @Column(name = "url")
    private String url;

    public QuoteEntity() {
    }

    public QuoteEntity(Long idBooking, String idKey, String filename,String url) {
        this.idBooking = idBooking;
        this.idKey = idKey;
        this.filename = filename;
        this.url = url;
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

    public String getIdKey() {
        return idKey;
    }

    public void setIdKey(String idKey) {
        this.idKey = idKey;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

