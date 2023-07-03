package com.developer.colorblast.favoris.dto.request;

import java.io.Serializable;

public class FavorisRequest implements Serializable {
    private Long id_client;
    private Long id_pro;

    public FavorisRequest() {
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
