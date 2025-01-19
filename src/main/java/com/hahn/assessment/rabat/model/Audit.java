package com.hahn.assessment.rabat.model;

import com.hahn.assessment.rabat.model.enums.ActionType;
import com.hahn.assessment.rabat.model.enums.EntityName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "audit_log")
@Getter @Setter
public class Audit extends AbstractEntity{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ActionType action;

    @Enumerated(EnumType.STRING)
    @Column(name = "entity_name", nullable = false)
    private EntityName entityName;

    @Column(name = "entity_id", nullable = false)
    private String entityId;

    @Column(name = "performed_by")
    private String performedBy;
}
