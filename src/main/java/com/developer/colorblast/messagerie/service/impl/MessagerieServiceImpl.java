package com.developer.colorblast.messagerie.service.impl;

import com.developer.colorblast.messagerie.entity.MessagerieEntity;
import com.developer.colorblast.messagerie.service.MessagerieService;
import com.developer.colorblast.messagerie.repository.MessagerieRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class MessagerieServiceImpl implements MessagerieService {

    private final MessagerieRepository messagerieRepository;

    public MessagerieServiceImpl(MessagerieRepository messagerieRepository) {
        this.messagerieRepository = messagerieRepository;
    }

    @Override
    public List<MessagerieEntity> findAllMessagerie() {
        return messagerieRepository.findAll();
    }

    @Override
    public Optional<MessagerieEntity> findById(Long id) {
        return messagerieRepository.findById(id);
    }

    @Override
    public List<MessagerieEntity> getMessageriesByIdClient(Long idClient) {
        return messagerieRepository.findByIdClient(idClient);
    }

    @Override
    public List<MessagerieEntity> getMessageriesByIdPro(Long idPro) {
        return messagerieRepository.findByIdPro(idPro);
    }

    @Override
    public MessagerieEntity saveMessagerie(MessagerieEntity messagerieEntity) {
        return messagerieRepository.save(messagerieEntity);
    }

    @Override
    public MessagerieEntity updateMessagerie(MessagerieEntity messagerieEntity) {
        if (!messagerieRepository.existsById(messagerieEntity.getId())) {
            throw new EntityNotFoundException("MessagerieEntity with ID " + messagerieEntity.getId() + " not found");
        }
        return messagerieRepository.save(messagerieEntity);
    }

    @Override
    public void deleteMessagerie(Long id) {
        messagerieRepository.deleteById(id);
    }
}
