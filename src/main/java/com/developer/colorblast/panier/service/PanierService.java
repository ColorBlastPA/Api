package com.developer.colorblast.panier.service;

import com.developer.colorblast.panier.entity.PanierEntity;

import java.util.List;
import java.util.Optional;

public interface PanierService {
    List<PanierEntity> findAllPaniers();
    Optional<PanierEntity> findById(Long id);
    PanierEntity savePanier(PanierEntity panierEntity);
    PanierEntity updatePanier(PanierEntity panierEntity);
    void deletePanier(Long id);

    List<PanierEntity> findPaniersByClientId(Long clientId);
}

