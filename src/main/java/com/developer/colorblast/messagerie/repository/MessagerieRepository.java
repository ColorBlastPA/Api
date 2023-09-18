package com.developer.colorblast.messagerie.repository;

import com.developer.colorblast.messagerie.entity.MessagerieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessagerieRepository extends JpaRepository<MessagerieEntity, Long> {
    List<MessagerieEntity> findByIdClient(Long idClient);
    List<MessagerieEntity> findByIdPro(Long idPro);

}
