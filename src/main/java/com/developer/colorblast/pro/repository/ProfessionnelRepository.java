package com.developer.colorblast.pro.repository;

import com.developer.colorblast.client.entity.ClientEntity;
import com.developer.colorblast.pro.entity.ProfessionnelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProfessionnelRepository extends JpaRepository<ProfessionnelEntity, Long> {
    Optional<ProfessionnelEntity> findByMail(String mail);

    Optional<ProfessionnelEntity> findByMailAndPassword(String mail, String password);

    List<ProfessionnelEntity> findByWaitingTrue();

    List<ProfessionnelEntity> findByWaitingFalse();
}
