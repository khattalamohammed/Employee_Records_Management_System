package com.hahn.assessment.rabat.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentDTO {

    @NotNull(message = "Department ID is required.")
    private Long id;

    private String name;
}
