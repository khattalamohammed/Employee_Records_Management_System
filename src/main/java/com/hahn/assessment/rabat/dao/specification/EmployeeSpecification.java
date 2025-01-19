package com.hahn.assessment.rabat.dao.specification;

import com.hahn.assessment.rabat.dto.params.EmployeeFilterDTO;
import com.hahn.assessment.rabat.model.Employee;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class EmployeeSpecification {

    private EmployeeSpecification() {
        throw new IllegalStateException("Utility class");
    }

    public static Specification<Employee> filterEmployees(EmployeeFilterDTO filterDTO) {
        return (root, query, criteriaBuilder) -> {
            var predicates = criteriaBuilder.conjunction();

            // Filter by query (name, jobTitle, ID)
            if (StringUtils.hasText(filterDTO.getQuery())) {
                String searchQuery = "%" + filterDTO.getQuery().toLowerCase() + "%";
                predicates.getExpressions().add(
                        criteriaBuilder.or(
                                criteriaBuilder.like(criteriaBuilder.lower(root.get("firstName")), searchQuery),
                                criteriaBuilder.like(criteriaBuilder.lower(root.get("lastName")), searchQuery),
                                criteriaBuilder.like(criteriaBuilder.lower(root.get("jobTitle")), searchQuery),
                                criteriaBuilder.like(root.get("id").as(String.class), searchQuery)
                        )
                );
            }

            // Filter by employment status
            if (filterDTO.getStatus() != null) {
                predicates.getExpressions().add(
                        criteriaBuilder.equal(root.get("status"), filterDTO.getStatus())
                );
            }

            // Filter by department ID
            if (filterDTO.getDepartmentId() != null) {
                predicates.getExpressions().add(
                        criteriaBuilder.equal(root.get("department").get("id"), filterDTO.getDepartmentId())
                );
            }

            // Filter by hire date
            if (filterDTO.getHireDate() != null) {
                predicates.getExpressions().add(
                        criteriaBuilder.equal(root.get("hireDate"), filterDTO.getHireDate())
                );
            }

            return predicates;
        };
    }
}
