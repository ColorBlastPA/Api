package com.developer.colorblast.pro.entity;

import com.developer.colorblast.certificates.entity.CertificateEntity;

public class ProfessionnelData {
    ProfessionnelEntity pro;
    CertificateEntity certificate;

    public ProfessionnelData(ProfessionnelEntity pro, CertificateEntity certificate) {
        this.pro = pro;
        this.certificate = certificate;
    }

    public ProfessionnelEntity getPro() {
        return pro;
    }

    public void setPro(ProfessionnelEntity pro) {
        this.pro = pro;
    }

    public CertificateEntity getCertificate() {
        return certificate;
    }

    public void setCertificate(CertificateEntity certificate) {
        this.certificate = certificate;
    }
}
