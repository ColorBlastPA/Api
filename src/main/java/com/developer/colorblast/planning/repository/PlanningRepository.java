package com.developer.colorblast.planning.repository;

import com.developer.colorblast.planning.entity.PlanningEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanningRepository extends JpaRepository<PlanningEntity, Long> {
    List<PlanningEntity> findAllByIdClient(Long idClient);
    List<PlanningEntity> findAllByIdPro(Long idPro);

    void deleteByIdBooking(Long idBooking);
}
