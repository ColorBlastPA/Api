package com.developer.colorblast.favoris.service;


import com.developer.colorblast.favoris.entity.FavorisEntity;
import org.springframework.stereotype.Service;

import java.util.List;
public interface FavorisService {
    FavorisEntity saveFavoris(FavorisEntity favorisEntity);
    List<FavorisEntity> getAllFavoris();

    void deleteFavoris(Long id);
}
