package com.unipz.xhm.fshk.backendsystem.service.jwt;

import com.unipz.xhm.fshk.backendsystem.model.Admin;
import com.unipz.xhm.fshk.backendsystem.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AdminServiceImpl implements UserDetailsService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        //Write logic to fetch customer from DB
        Admin admin= adminRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Admin not found with email: "+email));

        return new User(admin.getEmail(), admin.getPassword(), Collections.emptyList());
    }
}
