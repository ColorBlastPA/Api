package com.developer.colorblast.admin.repository;

import com.developer.colorblast.admin.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminEntity, Long> {
    AdminEntity findByMailAndPassword(String mail, String password);
}

