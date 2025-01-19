package com.hahn.assessment.rabat.controller;

import com.hahn.assessment.rabat.dto.EmployeeDTO;
import com.hahn.assessment.rabat.dto.params.EmployeeFilterDTO;
import com.hahn.assessment.rabat.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority(T(com.hahn.assessment.rabat.model.enums.SystemRole).ROLE_ADMIN.name())")
    public ResponseEntity<Page<EmployeeDTO>> getAll(EmployeeFilterDTO filter) {
        return ResponseEntity.ok(employeeService.getAll(filter));
    }
}
