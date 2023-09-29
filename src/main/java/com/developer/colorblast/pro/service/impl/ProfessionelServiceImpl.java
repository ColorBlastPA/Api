package com.developer.colorblast.pro.service.impl;

import com.developer.colorblast.pro.dto.mapper.ProfessionnelMapper;
import com.developer.colorblast.pro.dto.request.ProfessionnelRequest;
import com.developer.colorblast.pro.dto.response.ProfessionnelResponse;
import com.developer.colorblast.pro.entity.ProfessionnelEntity;
import com.developer.colorblast.pro.repository.ProfessionnelRepository;
import com.developer.colorblast.pro.service.ProfessionnelService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessionelServiceImpl implements ProfessionnelService {

    private final ProfessionnelRepository professionnelRepository;

    public ProfessionelServiceImpl(ProfessionnelRepository professionnelRepository) {
        this.professionnelRepository = professionnelRepository;
    }

    @Override
    public List<ProfessionnelEntity> findAllProfessionnel() {
        return professionnelRepository.findAll();
    }

    @Override
    public Optional<ProfessionnelEntity> findById(Long id) {
        return professionnelRepository.findById(id);
    }

    @Override
    public ProfessionnelEntity saveProfessionnel(ProfessionnelEntity professionnelEntity) {
        return professionnelRepository.save(professionnelEntity);
    }

    @Override
    public ProfessionnelEntity updateProfessionnel(ProfessionnelEntity professionnelEntity) {
        if (!professionnelRepository.existsById(professionnelEntity.getId())) {
            throw new EntityNotFoundException("ProEntity with ID " + professionnelEntity.getId() + " not found");
        }
        return professionnelRepository.save(professionnelEntity);
    }

    @Override
    public void deleteProfessionnel(Long id) {
        professionnelRepository.deleteById(id);
    }

    @Override
    public Optional<ProfessionnelEntity> findByMail(String email) {
        return professionnelRepository.findByMail(email);
    }

    @Override
    public Optional<ProfessionnelEntity> findByMailAndPassword(String mail, String password) {
        return professionnelRepository.findByMailAndPassword(mail, password);
    }

    @Override
    public ProfessionnelResponse saveProfessionnel(ProfessionnelRequest professionnelRequest) {
        ProfessionnelEntity professionnelEntity = ProfessionnelMapper.MAPPER.fromRequestToEntity(professionnelRequest);
        professionnelRepository.save(professionnelEntity);
        return ProfessionnelMapper.MAPPER.fromEntityToResponse(professionnelEntity);
    }

    @Override
    public ProfessionnelResponse updateProfessionnel(ProfessionnelRequest professionnelRequest, Long id) {
        Optional<ProfessionnelEntity> checkExistingProfessionnel = findById(id);
        if (!checkExistingProfessionnel.isPresent())
            throw new RuntimeException("Professionnel Id " + id + " Not Found!");

        ProfessionnelEntity professionnelEntity = ProfessionnelMapper.MAPPER.fromRequestToEntity(professionnelRequest);
        professionnelEntity.setId(id);
        professionnelRepository.save(professionnelEntity);
        return ProfessionnelMapper.MAPPER.fromEntityToResponse(professionnelEntity);
    }

    @Override
    public List<ProfessionnelEntity> getProfessionnelsByWaitingTrue() {
        return professionnelRepository.findByWaitingTrue();
    }

    @Override
    public List<ProfessionnelEntity> getProfessionnelsByWaitingFalse() {
        return professionnelRepository.findByWaitingFalse();
    }

}
