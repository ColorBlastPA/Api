package com.developer.colorblast.admin.service;

import com.developer.colorblast.admin.entity.AdminEntity;

import java.util.List;

public interface AdminService {
    List<AdminEntity> getAllAdmins();
    AdminEntity getAdminById(Long id);
    AdminEntity createAdmin(AdminEntity admin);
    AdminEntity updateAdmin(Long id, AdminEntity admin);
    void deleteAdmin(Long id);

    AdminEntity loginAdmin(String mail, String password);
}
