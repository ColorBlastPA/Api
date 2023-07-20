package com.developer.colorblast.panier.service.impl;

import com.developer.colorblast.panier.entity.PanierEntity;
import com.developer.colorblast.panier.repository.PanierRepository;
import com.developer.colorblast.panier.service.PanierService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PanierServiceImpl implements PanierService {

    private final PanierRepository panierRepository;

    public PanierServiceImpl(PanierRepository panierRepository) {
        this.panierRepository = panierRepository;
    }

    @Override
    public List<PanierEntity> findAllPaniers() {
        return panierRepository.findAll();
    }

    @Override
    public Optional<PanierEntity> findById(Long id) {
        return panierRepository.findById(id);
    }

    @Override
    public PanierEntity savePanier(PanierEntity panierEntity) {
        return panierRepository.save(panierEntity);
    }

    @Override
    public PanierEntity updatePanier(PanierEntity panierEntity) {
        if (!panierRepository.existsById(panierEntity.getId())) {
            throw new EntityNotFoundException("PanierEntity with ID " + panierEntity.getId() + " not found");
        }
        return panierRepository.save(panierEntity);
    }

    @Override
    public void deletePanier(Long id) {
        panierRepository.deleteById(id);
    }

    @Override
    public List<PanierEntity> findPaniersByClientId(Long clientId) {
        return panierRepository.findAllByIdClient(clientId);
    }

}
