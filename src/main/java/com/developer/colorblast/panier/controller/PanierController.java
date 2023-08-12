package com.developer.colorblast.panier.controller;

import com.developer.colorblast.panier.dto.PanierData;
import com.developer.colorblast.panier.entity.PanierEntity;
import com.developer.colorblast.panier.service.PanierService;
import com.developer.colorblast.product.entity.ProductEntity;
import com.developer.colorblast.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paniers")
public class PanierController {

    private final PanierService panierService;

    private final ProductService productService;

    public PanierController(PanierService panierService, ProductService productService) {
        this.panierService = panierService;
        this.productService = productService;
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
    public ResponseEntity<List<PanierData>> getPaniersByClientId(@PathVariable Long clientId) {
        List<PanierData> datas = new ArrayList<>();
        List<PanierEntity> paniers = panierService.findPaniersByClientId(clientId);

        for (PanierEntity panier : paniers) {
            Optional<ProductEntity> product = productService.findById(panier.getIdProduct());
            datas.add(new PanierData(panier.getId(),product.get()));
        }

        return new ResponseEntity<>(datas, HttpStatus.OK);
    }


}

