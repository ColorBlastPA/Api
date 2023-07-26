package com.developer.colorblast.favoris.service.impl;


import com.developer.colorblast.favoris.entity.FavorisEntity;
import com.developer.colorblast.favoris.repository.FavorisRepository;
import com.developer.colorblast.favoris.service.FavorisService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FavorisServiceImpl implements FavorisService {

    private final FavorisRepository favorisRepository;

    public FavorisServiceImpl(FavorisRepository favorisRepository) {
        this.favorisRepository = favorisRepository;
    }

    @Override
    public FavorisEntity saveFavoris(FavorisEntity favorisEntity) {
        return favorisRepository.save(favorisEntity);
    }


    @Override
    public List<FavorisEntity> getAllFavoris() {
        return favorisRepository.findAll();
    }
    @Override
    public void deleteFavoris(Long id) {
        favorisRepository.deleteById(id);
    }

}


