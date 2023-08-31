package com.developer.colorblast.certificates.controller;

import com.developer.colorblast.certificates.service.CertificateService;
import com.developer.colorblast.certificates.entity.CertificateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/certificates")
public class CertificateController {

    private final CertificateService certificateService;

    @Autowired
    public CertificateController(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    @GetMapping
    public ResponseEntity<List<CertificateEntity>> getAllCertificates() {
        List<CertificateEntity> certificates = certificateService.getAllCertificates();
        return new ResponseEntity<>(certificates, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CertificateEntity> getCertificateById(@PathVariable Long id) {
        CertificateEntity certificate = certificateService.getCertificateById(id);
        if (certificate != null) {
            return new ResponseEntity<>(certificate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<CertificateEntity> createCertificate(@RequestBody CertificateEntity certificate) {
        CertificateEntity createdCertificate = certificateService.createCertificate(certificate);
        return new ResponseEntity<>(createdCertificate, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCertificate(@PathVariable Long id) {
        CertificateEntity certificate = certificateService.getCertificateById(id);
        if (certificate != null) {
            certificateService.deleteCertificate(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
