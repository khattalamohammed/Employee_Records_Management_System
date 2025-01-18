package com.hahn.assessment.rabat.service;

import com.hahn.assessment.rabat.dto.AuthenticationDTO;
import com.hahn.assessment.rabat.dto.TokenDTO;

public interface AuthenticationService {
    TokenDTO login(AuthenticationDTO authenticationDTO);
}
