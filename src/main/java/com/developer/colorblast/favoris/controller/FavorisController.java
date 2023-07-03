package com.developer.colorblast.favoris.controller;

import com.developer.colorblast.client.entity.ClientEntity;
import com.developer.colorblast.favoris.dto.request.FavorisRequest;
import com.developer.colorblast.favoris.dto.response.FavorisResponse;
import com.developer.colorblast.favoris.entity.FavorisEntity;
import com.developer.colorblast.favoris.service.FavorisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favoris")
public class FavorisController {

    private final FavorisService favorisService;

    @Autowired
    public FavorisController(FavorisService favorisService) {
        this.favorisService = favorisService;
    }

    @PostMapping
    public FavorisEntity createFavoris(@RequestBody FavorisEntity favorisEntity) {
        return favorisService.saveFavoris(favorisEntity);
    }


   /* @GetMapping("/{id_client}")
    public List<FavorisEntity> getFavorisByIdClient(@PathVariable(name = "id_client") Long id_client) {
        return favorisService.getFavorisByClientId(id_client);
    }*/




    @GetMapping
    public ResponseEntity<List<FavorisEntity>> getAllFavoris() {
        List<FavorisEntity> favorisList = favorisService.getAllFavoris();
        return ResponseEntity.ok(favorisList);
    }

}
