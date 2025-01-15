package com.hahn.assessment.rabat.model;

import com.hahn.assessment.rabat.model.enums.SystemRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "rt_role")
@Getter @Setter
public class Role extends AbstractEntity{
    @Enumerated(EnumType.STRING)
    @Column(name = "name", unique = true, nullable = false)
    private SystemRole name;
}
