package com.hahn.assessment.rabat.service;

import com.hahn.assessment.rabat.dto.EmployeeDTO;
import com.hahn.assessment.rabat.dto.params.EmployeeFilterDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {

    Page<EmployeeDTO> getAll(EmployeeFilterDTO filter);

    Long save(EmployeeDTO employeeDTO);

    Long update(Long id, EmployeeDTO employeeDTO);

    Long delete(Long id);
}
