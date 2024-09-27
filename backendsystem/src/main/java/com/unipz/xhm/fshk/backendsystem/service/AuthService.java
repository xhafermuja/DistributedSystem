package com.unipz.xhm.fshk.backendsystem.service;

import com.unipz.xhm.fshk.backendsystem.dto.SignupRequest;
import com.unipz.xhm.fshk.backendsystem.model.Admin;

public interface AuthService {

    Admin createAdmin(SignupRequest signupRequest);
}
