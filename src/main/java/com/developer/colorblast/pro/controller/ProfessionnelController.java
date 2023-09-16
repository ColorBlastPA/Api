package com.developer.colorblast.pro.controller;


import com.developer.colorblast.certificates.entity.CertificateEntity;
import com.developer.colorblast.certificates.service.CertificateService;
import com.developer.colorblast.favoris.entity.FavorisEntity;
import com.developer.colorblast.pro.dto.request.ProfessionnelRequest;
import com.developer.colorblast.pro.dto.response.ProfessionnelResponse;
import com.developer.colorblast.pro.entity.ProfessionnelData;
import com.developer.colorblast.pro.entity.ProfessionnelEntity;
import com.developer.colorblast.pro.service.ProfessionnelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/professionnel")
public class ProfessionnelController {

    private final ProfessionnelService professionnelService;

    private final CertificateService certificateService;

    public ProfessionnelController(ProfessionnelService professionnelService, CertificateService certificateService) {
        this.professionnelService = professionnelService;
        this.certificateService = certificateService;
    }

    @GetMapping
    public List<ProfessionnelEntity> findAllProfessionnel() {
        return professionnelService.findAllProfessionnel();
    }

    @GetMapping("/{id}")
    public Optional<ProfessionnelEntity> findProfessionnelById(@PathVariable("id") Long id) {
        return professionnelService.findById(id);
    }

    @GetMapping("/certif/{id}")
    public ProfessionnelData findProfessionnelByIdWithCertificate(@PathVariable("id") Long id) {
        Optional<ProfessionnelEntity> pro = professionnelService.findById(id);
        CertificateEntity certificate = new CertificateEntity();
        if(pro.isPresent()){
            certificate = certificateService.getCertificateById(pro.get().getIdCertificate());

        }
        ProfessionnelData proData = new ProfessionnelData(pro.get(), certificate);
        return  proData;
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
            if(pro.get().getWaiting()){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("en attente!!!");
            }else{
                List<CertificateEntity> certificate = certificateService.getCertificatesByProId(pro.get().getId());
                ProfessionnelData proData = new ProfessionnelData(pro.get(),certificate.get(0));
                return ResponseEntity.ok(proData);
            }

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/waiting")
    public List<?> getProfessionnelsWithWaitingTrue() {
        List<ProfessionnelEntity> pro = professionnelService.getProfessionnelsByWaitingTrue();
        List<ProfessionnelData> result = new ArrayList<>();
        for (ProfessionnelEntity professionnel : pro) {
            if (professionnel.getIdCertificate() != null) {
                ProfessionnelData data = new ProfessionnelData(professionnel,certificateService.getCertificateById(professionnel.getIdCertificate()));
                result.add(data);
            }
        }
        return result;
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

