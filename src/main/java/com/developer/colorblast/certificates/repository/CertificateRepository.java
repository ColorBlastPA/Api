package com.developer.colorblast.certificates.repository;

import com.developer.colorblast.certificates.entity.CertificateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificateRepository extends JpaRepository<CertificateEntity, Long> {
    List<CertificateEntity> findByIdPro(Long idPro);
}
