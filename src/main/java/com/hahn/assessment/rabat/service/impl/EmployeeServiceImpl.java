package com.hahn.assessment.rabat.service.impl;

import com.hahn.assessment.rabat.annotation.Auditable;
import com.hahn.assessment.rabat.dao.EmployeeRepository;
import com.hahn.assessment.rabat.dao.specification.EmployeeSpecification;
import com.hahn.assessment.rabat.dto.EmployeeDTO;
import com.hahn.assessment.rabat.dto.params.EmployeeFilterDTO;
import com.hahn.assessment.rabat.model.Employee;
import com.hahn.assessment.rabat.model.enums.ActionType;
import com.hahn.assessment.rabat.model.enums.EntityName;
import com.hahn.assessment.rabat.service.EmployeeService;
import com.hahn.assessment.rabat.service.mapper.EmployeeMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public Page<EmployeeDTO> getAll(EmployeeFilterDTO filter) {
        var spec = EmployeeSpecification.filterEmployees(filter);
        Page<Employee> employees = employeeRepository.findAll(spec,
                filter.getPageable());
        return employees.map(employeeMapper::toDto);
    }

    @Override
    @Transactional
    @Auditable(action = ActionType.CREATE, entity = EntityName.EMPLOYEE)
    public Long save(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.toEntity(employeeDTO);
        return employeeRepository.save(employee).getId();
    }

    @Override
    @Transactional
    @Auditable(action = ActionType.UPDATE, entity = EntityName.EMPLOYEE)
    public Long update(Long id, EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        Employee updatedEmployee = employeeMapper.toEntity(employeeDTO);
        updatedEmployee.setId(employee.getId());
        return employeeRepository.save(updatedEmployee).getId();
    }

    @Override
    @Transactional
    @Auditable(action = ActionType.DELETE, entity = EntityName.EMPLOYEE)
    public Long delete(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        employeeRepository.delete(employee);
        return id;
    }
}
