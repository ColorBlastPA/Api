package com.developer.colorblast.pro.controller;


import com.developer.colorblast.client.entity.ClientEntity;
import com.developer.colorblast.pro.dto.request.ProfessionnelRequest;
import com.developer.colorblast.pro.dto.response.ProfessionnelResponse;
import com.developer.colorblast.pro.entity.ProfessionnelEntity;
import com.developer.colorblast.pro.service.ProfessionnelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/professionnel")
public class ProfessionnelController {

    private final ProfessionnelService professionnelService;

    public ProfessionnelController(ProfessionnelService professionnelService) {
        this.professionnelService = professionnelService;
    }

    @GetMapping
    public List<ProfessionnelEntity> findAllProfessionnel() {
        return professionnelService.findAllProfessionnel();
    }

    @GetMapping("/{id}")
    public Optional<ProfessionnelEntity> findProfessionnelById(@PathVariable("id") Long id) {
        return professionnelService.findById(id);
    }

    @PostMapping
    public ProfessionnelEntity saveProfessionnel(@RequestBody ProfessionnelEntity professionnelEntity) {
        return professionnelService.saveProfessionnel(professionnelEntity);
    }

    @PutMapping
    public ProfessionnelEntity updateProfessionnel(@RequestBody ProfessionnelEntity professionnelEntity) {
        //professionnelService.deleteProfessionnel(professionnelEntity.getId());
        return professionnelService.updateProfessionnel(professionnelEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteProfessionnel(@PathVariable("id") Long id) {
        professionnelService.deleteProfessionnel(id);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginPro(@RequestBody Map<String, String> loginRequest) {
        String mail = loginRequest.get("mail");
        String password = loginRequest.get("password");

        Optional<ProfessionnelEntity> pro = professionnelService.findByMailAndPassword(mail, password);
        if (pro.isPresent()) {
            return ResponseEntity.ok(pro.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/res")
    public ProfessionnelResponse saveProfessionnelResponse(@RequestBody ProfessionnelRequest professionnelRequest) {
        return professionnelService.saveProfessionnel(professionnelRequest);
    }

    @PutMapping("/res/{id}")
    public ProfessionnelResponse updateProfessionnelResponse(@RequestBody ProfessionnelRequest professionnelRequest, @PathVariable("id") Long id) {
        return professionnelService.updateProfessionnel(professionnelRequest, id);
    }
}

