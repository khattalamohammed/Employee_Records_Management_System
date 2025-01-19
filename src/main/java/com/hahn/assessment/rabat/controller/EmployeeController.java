package com.hahn.assessment.rabat.controller;

import com.hahn.assessment.rabat.dto.EmployeeDTO;
import com.hahn.assessment.rabat.dto.params.EmployeeFilterDTO;
import com.hahn.assessment.rabat.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@Tag(name = "Employee", description = "Operations related to employee management.")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_DEPARTMENT_MANAGER', 'ROLE_HR_MANAGER')")
    @Operation(
            summary = "Get all employees",
            description = "Retrieve a paginated list of employees based on filter criteria.",
            security = @SecurityRequirement(name = "Bearer Authentication")
    )
    public ResponseEntity<Page<EmployeeDTO>> getAll(
            @Parameter(description = "Filter criteria for employees")
            EmployeeFilterDTO filter) {
        return ResponseEntity.ok(employeeService.getAll(filter));
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_HR_MANAGER')")
    @Operation(
            summary = "Save a new employee",
            description = "Create a new employee and return the generated ID.",
            security = @SecurityRequirement(name = "Bearer Authentication")
    )
    public ResponseEntity<Long> saveEmployee(
            @Parameter(description = "Employee details to be saved")
            @RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(employeeService.save(employeeDTO));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_HR_MANAGER')")
    @Operation(
            summary = "Update an existing employee",
            description = "Update the details of an existing employee by ID.",
            security = @SecurityRequirement(name = "Bearer Authentication")
    )
    public ResponseEntity<Long> updateEmployee(
            @Parameter(description = "ID of the employee to be updated")
            @PathVariable Long id,
            @Parameter(description = "Updated employee details")
            @RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(employeeService.update(id, employeeDTO));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_HR_MANAGER')")
    @Operation(
            summary = "Delete an employee",
            description = "Delete an employee by ID.",
            security = @SecurityRequirement(name = "Bearer Authentication")
    )
    public ResponseEntity<Long> deleteEmployee(
            @Parameter(description = "ID of the employee to be deleted")
            @PathVariable Long id) {
        return ResponseEntity.ok(employeeService.delete(id));
    }
}
