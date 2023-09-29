package com.developer.colorblast.planning.controller;

import com.developer.colorblast.planning.entity.PlanningEntity;
import com.developer.colorblast.planning.service.PlanningService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/planning")
public class PlanningController {

    private final PlanningService planningService;

    public PlanningController(PlanningService planningService) {
        this.planningService = planningService;
    }

    @GetMapping
    public ResponseEntity<List<PlanningEntity>> getAllPlanning() {
        List<PlanningEntity> allPlanning = planningService.findAllPlanning();
        return new ResponseEntity<>(allPlanning, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanningEntity> getPlanningById(@PathVariable Long id) {
        Optional<PlanningEntity> planningOptional = planningService.findById(id);
        return planningOptional.map(planning -> new ResponseEntity<>(planning, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<PlanningEntity> createPlanning(@RequestBody PlanningEntity planningEntity) {
        PlanningEntity createdPlanning = planningService.savePlanning(planningEntity);
        return new ResponseEntity<>(createdPlanning, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanningEntity> updatePlanning(@PathVariable Long id, @RequestBody PlanningEntity planningEntity) {
        planningEntity.setId(id);
        PlanningEntity updatedPlanning = planningService.updatePlanning(planningEntity);
        return new ResponseEntity<>(updatedPlanning, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlanning(@PathVariable Long id) {
        planningService.deletePlanning(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/client/{idClient}")
    public List<PlanningEntity> getPlanningsByClientId(@PathVariable Long idClient) {
        return planningService.findPlanningsByIdClient(idClient);
    }

    @GetMapping("/pro/{idPro}")
    public List<PlanningEntity> getPlanningsByProId(@PathVariable Long idPro) {
        return planningService.findPlanningsByIdPro(idPro);
    }

    @DeleteMapping("/deleteByBookingId/{idBooking}")
    public ResponseEntity<String> deleteByBookingId(@PathVariable Long idBooking) {
        planningService.deleteByBookingId(idBooking);
        return new ResponseEntity<>("Planning deleted successfully", HttpStatus.OK);
    }
}

