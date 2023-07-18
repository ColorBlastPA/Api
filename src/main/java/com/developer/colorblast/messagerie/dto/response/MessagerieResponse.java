package com.developer.colorblast.messagerie.dto.response;

import java.io.Serializable;
import java.util.Date;

public class MessagerieResponse implements Serializable {

    private Long id;

    private Long idClient;

    private Long idPro;

    private String lastMessage;

    private Date dLastMessage;

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

