package com.unipz.xhm.fshk.backendsystem.controller;


import com.unipz.xhm.fshk.backendsystem.dto.SignupRequest;
import com.unipz.xhm.fshk.backendsystem.model.Admin;
import com.unipz.xhm.fshk.backendsystem.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signup")
@CrossOrigin()
public class SignupController {

    private final AuthService authService;

    @Autowired
    public SignupController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<?> signupCustomer(@RequestBody SignupRequest signupRequest) {
        Admin createdCustomer = authService.createAdmin(signupRequest);
        if (createdCustomer != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create customer");
        }
    }
}
