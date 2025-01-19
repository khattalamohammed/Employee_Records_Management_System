package com.hahn.assessment.rabat.dto;

import com.hahn.assessment.rabat.model.enums.EmploymentStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private String jobTitle;
    private DepartmentDTO departmentDTO;
    private LocalDate hireDate;
    private EmploymentStatus status;
    private ContactDTO contactDTO;
    private AddressDTO addressDTO;
}
