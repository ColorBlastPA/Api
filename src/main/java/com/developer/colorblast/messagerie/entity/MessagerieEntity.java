package com.developer.colorblast.messagerie.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "messagerie")
public class MessagerieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_client")
    private Long idClient;

    @Column(name = "id_pro")
    private Long idPro;

    @Column(name = "last_message")
    private String lastMessage;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "d_last_message")
    private Date dLastMessage;

    public MessagerieEntity() {
    }

    public MessagerieEntity(Long id, Long idClient, Long idPro, String lastMessage, Date dLastMessage) {
        this.id = id;
        this.idClient = idClient;
        this.idPro = idPro;
        this.lastMessage = lastMessage;
        this.dLastMessage = dLastMessage;
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

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public Date getDLastMessage() {
        return dLastMessage;
    }

    public void setDLastMessage(Date dLastMessage) {
        this.dLastMessage = dLastMessage;
    }
}
