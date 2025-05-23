package com.developer.colorblast.messagerie.service;

import com.developer.colorblast.messagerie.entity.MessagerieEntity;
import java.util.List;
import java.util.Optional;

public interface MessagerieService {
    List<MessagerieEntity> findAllMessagerie();
    Optional<MessagerieEntity> findById(Long id);
    MessagerieEntity saveMessagerie(MessagerieEntity messagerieEntity);
    MessagerieEntity updateMessagerie(MessagerieEntity messagerieEntity);
    void deleteMessagerie(Long id);
    List<MessagerieEntity> getMessageriesByIdClient(Long idClient);

    List<MessagerieEntity> getMessageriesByIdPro(Long idPro);

    MessagerieEntity getMessagerieByClientAndPro(Long idClient, Long idPro);


}

