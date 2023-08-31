package com.developer.colorblast.certificates.entity;

import javax.persistence.*;

@Entity
@Table(name = "certificates")
public class CertificateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "clef", columnDefinition = "VARCHAR(36)")
    private String idKey;

    @Column(name = "id_pro")
    private Long idPro;

    @Column(name = "filename")
    private String filename;

    public CertificateEntity(Long id, String idKey, Long idPro, String filename) {
        this.id = id;
        this.idKey = idKey;
        this.idPro = idPro;
        this.filename = filename;
    }

    public CertificateEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdKey() {
        return idKey;
    }

    public void setIdKey(String idKey) {
        this.idKey = idKey;
    }

    public Long getIdPro() {
        return idPro;
    }

    public void setIdPro(Long idPro) {
        this.idPro = idPro;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
