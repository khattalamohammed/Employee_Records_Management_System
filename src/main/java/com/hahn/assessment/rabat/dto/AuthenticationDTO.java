package com.hahn.assessment.rabat.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "User credentials for authentication")
public class AuthenticationDTO {

    @Schema(description = "Username of the user")
    private String username;

    @Schema(description = "Password of the user")
    private String password;
}
