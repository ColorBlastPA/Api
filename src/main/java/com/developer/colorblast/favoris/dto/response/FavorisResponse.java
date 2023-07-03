package com.developer.colorblast.favoris.dto.response;

import java.io.Serializable;

public class FavorisResponse implements Serializable {
    private Long id;
    private Long id_client;
    private Long id_pro;

    public FavorisResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_client() {
        return id_client;
    }

    public void setId_client(Long id_client) {
        this.id_client = id_client;
    }

    public Long getId_pro() {
        return id_pro;
    }

    public void setId_pro(Long id_pro) {
        this.id_pro = id_pro;
    }
}

