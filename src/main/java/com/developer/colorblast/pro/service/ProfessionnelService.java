package com.developer.colorblast.pro.service;

import com.developer.colorblast.client.entity.ClientEntity;
import com.developer.colorblast.pro.dto.request.ProfessionnelRequest;
import com.developer.colorblast.pro.dto.response.ProfessionnelResponse;
import com.developer.colorblast.pro.entity.ProfessionnelEntity;

import java.util.List;
import java.util.Optional;

public interface ProfessionnelService {
    List<ProfessionnelEntity> findAllProfessionnel();
    Optional<ProfessionnelEntity> findById(Long id);
    ProfessionnelEntity saveProfessionnel(ProfessionnelEntity professionnelEntity);
    ProfessionnelEntity updateProfessionnel(ProfessionnelEntity professionnelEntity);
    void deleteProfessionnel(Long id);

    Optional<ProfessionnelEntity> findByMail(String email);

    Optional<ProfessionnelEntity> findByMailAndPassword(String mail, String password);

    ProfessionnelResponse saveProfessionnel(ProfessionnelRequest professionnelRequest);

    ProfessionnelResponse updateProfessionnel(ProfessionnelRequest professionnelRequest, Long id);

    List<ProfessionnelEntity> getProfessionnelsByWaitingTrue();

    List<ProfessionnelEntity> getProfessionnelsByWaitingFalse();
}
