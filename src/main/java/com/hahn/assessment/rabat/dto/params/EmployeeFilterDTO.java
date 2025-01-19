package com.hahn.assessment.rabat.dto.params;

import com.hahn.assessment.rabat.model.enums.EmploymentStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Optional;

@Getter
@Setter
@Builder
public class EmployeeFilterDTO {
    private String query;
    private EmploymentStatus status;
    private Long departmentId;
    private LocalDate hireDate;
    Pageable pageable;

    public Pageable getPageable() {
        return Optional.ofNullable(pageable)
                .orElse(Pageable.ofSize(Integer.MAX_VALUE).withPage(0));
    }
}
