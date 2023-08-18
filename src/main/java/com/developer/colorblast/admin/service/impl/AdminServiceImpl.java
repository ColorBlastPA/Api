package com.developer.colorblast.admin.service.impl;

import com.developer.colorblast.admin.entity.AdminEntity;
import com.developer.colorblast.admin.repository.AdminRepository;
import com.developer.colorblast.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public List<AdminEntity> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public AdminEntity getAdminById(Long id) {
        Optional<AdminEntity> adminOptional = adminRepository.findById(id);
        return adminOptional.orElse(null);
    }

    @Override
    public AdminEntity createAdmin(AdminEntity admin) {
        return adminRepository.save(admin);
    }

    @Override
    public AdminEntity updateAdmin(Long id, AdminEntity admin) {
        admin.setId(id);
        return adminRepository.save(admin);
    }

    @Override
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

    @Override
    public AdminEntity loginAdmin(String mail, String password) {
        return adminRepository.findByMailAndPassword(mail, password);
    }


}
