package com.hahn.assessment.rabat.aspect;

import com.hahn.assessment.rabat.annotation.Auditable;
import com.hahn.assessment.rabat.dao.AuditRepository;
import com.hahn.assessment.rabat.model.Audit;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect {

    private final AuditRepository auditRepository;

    public AuditAspect(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    @AfterReturning(value = "@annotation(auditable)", returning = "result")
    public void afterMethodExecution(JoinPoint joinPoint, Auditable auditable, Object result) {
        String entityId = String.valueOf(result);

        // Get the current user (if using Spring Security)
        String performedBy = SecurityContextHolder.getContext().getAuthentication().getName();

        // Create and save the audit log
        Audit auditLog = new Audit();
        auditLog.setAction(auditable.action());
        auditLog.setEntityName(auditable.entity());
        auditLog.setEntityId(entityId);
        auditLog.setPerformedBy(performedBy);

        auditRepository.save(auditLog);
    }

}
