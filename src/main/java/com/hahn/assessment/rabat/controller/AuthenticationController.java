package com.hahn.assessment.rabat.controller;

import com.hahn.assessment.rabat.dto.AuthenticationDTO;
import com.hahn.assessment.rabat.dto.TokenDTO;
import com.hahn.assessment.rabat.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Operation(
            summary = "Login and obtain access token",
            description = "Authenticates a user and returns a JWT access token upon successful login.",
            responses = {
                    @ApiResponse(
                            description = "Access token",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = TokenDTO.class))
                    ),
                    @ApiResponse(
                            description = "Invalid credentials",
                            responseCode = "401"
                    )
            }
    )
    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody AuthenticationDTO authenticationDTO) {
        return ResponseEntity.ok(authenticationService.login(authenticationDTO));
    }
}
