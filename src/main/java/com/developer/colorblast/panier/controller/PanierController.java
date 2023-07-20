package com.developer.colorblast.panier.controller;

import com.developer.colorblast.panier.entity.PanierEntity;
import com.developer.colorblast.panier.service.PanierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paniers")
public class PanierController {

    private final PanierService panierService;

    public PanierController(PanierService panierService) {
        this.panierService = panierService;
    }

    @PostMapping
    public ResponseEntity<PanierEntity> createPanier(@RequestBody PanierEntity panierEntity) {
        PanierEntity createdPanier = panierService.savePanier(panierEntity);
        return new ResponseEntity<>(createdPanier, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PanierEntity> getPanierById(@PathVariable Long id) {
        Optional<PanierEntity> panier = panierService.findById(id);
        return panier.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PanierEntity> updatePanier(@PathVariable Long id, @RequestBody PanierEntity panierEntity) {
        panierEntity.setId(id);
        PanierEntity updatedPanier = panierService.updatePanier(panierEntity);
        return new ResponseEntity<>(updatedPanier, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePanier(@PathVariable Long id) {
        panierService.deletePanier(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<PanierEntity>> getPaniersByClientId(@PathVariable Long clientId) {
        List<PanierEntity> paniers = panierService.findPaniersByClientId(clientId);
        return new ResponseEntity<>(paniers, HttpStatus.OK);
    }


}

