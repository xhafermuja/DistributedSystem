package com.unipz.xhm.fshk.backendsystem.service;

import com.unipz.xhm.fshk.backendsystem.dto.SignupRequest;
import com.unipz.xhm.fshk.backendsystem.model.Admin;
import com.unipz.xhm.fshk.backendsystem.repository.AdminRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    private final AdminRepository adminRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Admin createAdmin(SignupRequest signupRequest) {
        //Check if customer already exist
        if (adminRepository.existsByEmail(signupRequest.getEmail())) {
            return null;
        }

        Admin admin = new Admin();
        BeanUtils.copyProperties(signupRequest,admin);

        //Hash the password before saving
        String hashPassword = passwordEncoder.encode(signupRequest.getPassword());
        admin.setPassword(hashPassword);
        Admin createdCustomer = adminRepository.save(admin);
        admin.setId(createdCustomer.getId());
        return admin;
    }
}
