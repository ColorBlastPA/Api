package com.developer.colorblast.planning.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "planning")
public class PlanningEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_client")
    private Long idClient;

    @Column(name = "id_pro")
    private Long idPro;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "d_date")
    private Date ddate;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "f_date")
    private Date fdate;

    @Column(name = "is_actif")
    private boolean isActif;

    public PlanningEntity() {
    }

    public PlanningEntity(Long id, Long idClient, Long idPro, Date dDate, Date fDate, boolean isActif) {
        this.id = id;
        this.idClient = idClient;
        this.idPro = idPro;
        this.ddate = dDate;
        this.fdate = fDate;
        this.isActif = isActif;
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

    public Long getIdPro() {
        return idPro;
    }

    public void setIdPro(Long idPro) {
        this.idPro = idPro;
    }

    public Date getDDate() {
        return ddate;
    }

    public void setDDate(Date dDate) {
        this.ddate = dDate;
    }

    public Date getFDate() {
        return fdate;
    }

    public void setFDate(Date fDate) {
        this.fdate = fDate;
    }

    public boolean isActif() {
        return isActif;
    }

    public void setActif(boolean actif) {
        isActif = actif;
    }
}

