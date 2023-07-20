package com.developer.colorblast.panier.repository;

import com.developer.colorblast.panier.entity.PanierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PanierRepository extends JpaRepository<PanierEntity, Long> {
    List<PanierEntity> findAllByIdClient(Long clientId);
}
