package com.hahn.assessment.rabat.service.mapper;

import com.hahn.assessment.rabat.dto.EmployeeDTO;
import com.hahn.assessment.rabat.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DepartmentMapper.class, ContactMapper.class, AddressMapper.class})
public interface EmployeeMapper {

    @Mapping(source = "department", target = "departmentDTO")
    @Mapping(source = "contact", target = "contactDTO")
    @Mapping(source = "address", target = "addressDTO")
    EmployeeDTO toDto(Employee employee);

    @Mapping(source = "departmentDTO", target = "department")
    @Mapping(source = "contactDTO", target = "contact")
    @Mapping(source = "addressDTO", target = "address")
    Employee toEntity(EmployeeDTO employeeDTO);
}