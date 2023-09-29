package com.developer.colorblast.planning.service.impl;

import com.developer.colorblast.planning.entity.PlanningEntity;
import com.developer.colorblast.planning.repository.PlanningRepository;
import com.developer.colorblast.planning.service.PlanningService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PlanningServiceImpl implements PlanningService {

    private final PlanningRepository planningRepository;

    public PlanningServiceImpl(PlanningRepository planningRepository) {
        this.planningRepository = planningRepository;
    }

    @Override
    public List<PlanningEntity> findAllPlanning() {
        return planningRepository.findAll();
    }

    @Override
    public Optional<PlanningEntity> findById(Long id) {
        return planningRepository.findById(id);
    }

    @Override
    public PlanningEntity savePlanning(PlanningEntity planningEntity) {
        return planningRepository.save(planningEntity);
    }

    @Override
    public PlanningEntity updatePlanning(PlanningEntity planningEntity) {
        if (!planningRepository.existsById(planningEntity.getId())) {
            throw new EntityNotFoundException("PlanningEntity with ID " + planningEntity.getId() + " not found");
        }
        return planningRepository.save(planningEntity);
    }

    @Override
    public void deletePlanning(Long id) {
        planningRepository.deleteById(id);
    }

    @Override
    public List<PlanningEntity> findPlanningsByIdClient(Long idClient) {
        return planningRepository.findAllByIdClient(idClient);
    }

    @Override
    public List<PlanningEntity> findPlanningsByIdPro(Long idPro) {
        return planningRepository.findAllByIdPro(idPro);
    }

    @Override
    @Transactional
    public void deleteByBookingId(Long idBooking) {
        planningRepository.deleteByIdBooking(idBooking);
    }
}

