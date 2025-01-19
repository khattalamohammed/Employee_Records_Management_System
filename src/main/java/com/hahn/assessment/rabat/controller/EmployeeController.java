package com.hahn.assessment.rabat.controller;

import com.hahn.assessment.rabat.dto.EmployeeDTO;
import com.hahn.assessment.rabat.dto.params.EmployeeFilterDTO;
import com.hahn.assessment.rabat.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_DEPARTMENT_MANAGER', 'ROLE_HR_MANAGER')")
    public ResponseEntity<Page<EmployeeDTO>> getAll(EmployeeFilterDTO filter) {
        return ResponseEntity.ok(employeeService.getAll(filter));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Long> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(employeeService.save(employeeDTO));
    }
}
