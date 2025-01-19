package com.hahn.assessment.rabat.annotation;

import com.hahn.assessment.rabat.model.enums.ActionType;
import com.hahn.assessment.rabat.model.enums.EntityName;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Auditable {
    ActionType action();
    EntityName entity();
}
