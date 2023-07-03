package com.developer.colorblast.favoris.repository;

import com.developer.colorblast.favoris.entity.FavorisEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FavorisRepository extends JpaRepository<FavorisEntity, Long> {

    //List<FavorisEntity> getFavorisByClientId(Long idClient);

}
