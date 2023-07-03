package com.developer.colorblast.favoris.entity;

import javax.persistence.*;

@Entity
@Table(name = "favoris")
public class FavorisEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_client")
    private Long id_client;

    @Column(name = "id_pro")
    private Long id_pro;

    public FavorisEntity(Long id, Long id_client, Long id_pro) {
        this.id = id;
        this.id_client = id_client;
        this.id_pro = id_pro;
    }

    public FavorisEntity() {

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
