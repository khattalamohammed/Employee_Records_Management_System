package com.hahn.assessment.rabat.dto;

import com.hahn.assessment.rabat.model.enums.EmploymentStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmployeeDTO {
    @NotBlank(message = "First name is required.")
    private String firstName;

    @NotBlank(message = "Last name is required.")
    private String lastName;

    @NotBlank(message = "Job title is required.")
    private String jobTitle;

    @NotNull(message = "Department is required.")
    private DepartmentDTO departmentDTO;

    @NotNull(message = "Hire date is required.")
    private LocalDate hireDate;

    @NotNull(message = "Employment status is required.")
    private EmploymentStatus status;

    @NotNull(message = "Contact information is required.")
    private ContactDTO contactDTO;

    @NotNull(message = "Address information is required.")
    private AddressDTO addressDTO;
}
