package com.unipz.xhm.fshk.backendsystem.controller;

import com.unipz.xhm.fshk.backendsystem.dto.LoginRequest;
import com.unipz.xhm.fshk.backendsystem.dto.LoginResponse;
import com.unipz.xhm.fshk.backendsystem.service.jwt.AdminServiceImpl;
import com.unipz.xhm.fshk.backendsystem.utils.JwtUtil;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/login")
@CrossOrigin()
public class LoginController {

    private final AuthenticationManager authenticationManager;

    private final AdminServiceImpl adminService;

    private final JwtUtil jwtUtil;

    @Autowired
    public LoginController(AuthenticationManager authenticationManager, AdminServiceImpl adminService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.adminService = adminService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    public LoginResponse login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) throws IOException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Incorrect email or password.");
        } catch (DisabledException disabledException) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Customer is not activated");
            return null;
        }
        final UserDetails userDetails = adminService.loadUserByUsername(loginRequest.getEmail());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

        return new LoginResponse(jwt);
    }
}
