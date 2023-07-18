package com.developer.colorblast.favoris.controller;

import com.developer.colorblast.favoris.entity.FavorisEntity;
import com.developer.colorblast.favoris.service.FavorisService;
import com.developer.colorblast.pro.entity.ProfessionnelEntity;
import com.developer.colorblast.pro.service.ProfessionnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/favoris")
public class FavorisController {

    private final FavorisService favorisService;

    private final ProfessionnelService professionnelService;

    @Autowired
    public FavorisController(FavorisService favorisService, ProfessionnelService professionnelService) {
        this.favorisService = favorisService;
        this.professionnelService = professionnelService;
    }

    @PostMapping
    public FavorisEntity createFavoris(@RequestBody FavorisEntity favorisEntity) {
        return favorisService.saveFavoris(favorisEntity);
    }


    @GetMapping("/{id_client}")
    public List<ProfessionnelEntity> getFavorisByIdClient(@PathVariable(name = "id_client") Long id_client) {
        List<FavorisEntity> allFavoris = favorisService.getAllFavoris();
        List<FavorisEntity> myFavoris = new ArrayList<>();
        List<ProfessionnelEntity> result = new ArrayList<>();

        for (FavorisEntity favoris : allFavoris) {
            if (favoris.getId_client().equals(id_client)) {
                myFavoris.add(favoris);
            }
        }

        for (FavorisEntity favoris : myFavoris) {
            Optional<ProfessionnelEntity> professionnel = professionnelService.findById(favoris.getId_pro());
            professionnel.ifPresent(result::add);
        }

        return result;
    }






    @GetMapping
    public ResponseEntity<List<FavorisEntity>> getAllFavoris() {
        List<FavorisEntity> favorisList = favorisService.getAllFavoris();
        return ResponseEntity.ok(favorisList);
    }

}
