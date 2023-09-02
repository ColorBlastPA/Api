package com.developer.colorblast.certificates.service;

import com.developer.colorblast.certificates.entity.CertificateEntity;

import java.util.List;

public interface CertificateService {
    List<CertificateEntity> getAllCertificates();
    CertificateEntity getCertificateById(Long id);
    CertificateEntity createCertificate(CertificateEntity certificate);
    List<CertificateEntity> getCertificatesByProId(Long idPro);
    void deleteCertificate(Long id);
}
