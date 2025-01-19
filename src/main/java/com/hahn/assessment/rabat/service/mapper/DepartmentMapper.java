package com.hahn.assessment.rabat.service.mapper;

import com.hahn.assessment.rabat.dto.DepartmentDTO;
import com.hahn.assessment.rabat.model.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper extends GenericMapper<Department, DepartmentDTO> {
}