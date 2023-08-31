package com.developer.colorblast.certificates.service.impl;

import com.developer.colorblast.certificates.entity.CertificateEntity;
import com.developer.colorblast.certificates.repository.CertificateRepository;
import com.developer.colorblast.certificates.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateServiceImpl implements CertificateService {

    private final CertificateRepository certificateRepository;

    @Autowired
    public CertificateServiceImpl(CertificateRepository certificateRepository) {
        this.certificateRepository = certificateRepository;
    }

    @Override
    public List<CertificateEntity> getAllCertificates() {
        return certificateRepository.findAll();
    }

    @Override
    public CertificateEntity getCertificateById(Long id) {
        return certificateRepository.findById(id).orElse(null);
    }

    @Override
    public CertificateEntity createCertificate(CertificateEntity certificate) {
        return certificateRepository.save(certificate);
    }

    @Override
    public void deleteCertificate(Long id) {
        certificateRepository.deleteById(id);
    }
}
