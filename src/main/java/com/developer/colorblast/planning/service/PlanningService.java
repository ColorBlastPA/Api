package com.developer.colorblast.planning.service;

import com.developer.colorblast.planning.entity.PlanningEntity;

import java.util.List;
import java.util.Optional;

public interface PlanningService {
    List<PlanningEntity> findAllPlanning();

    Optional<PlanningEntity> findById(Long id);

    PlanningEntity savePlanning(PlanningEntity planningEntity);

    PlanningEntity updatePlanning(PlanningEntity planningEntity);

    void deletePlanning(Long id);

    List<PlanningEntity> findPlanningsByIdClient(Long idClient);
    List<PlanningEntity> findPlanningsByIdPro(Long idPro);

    void deleteByBookingId(Long idBooking);
}
