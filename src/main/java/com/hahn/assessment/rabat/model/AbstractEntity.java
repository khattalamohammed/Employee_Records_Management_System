package com.hahn.assessment.rabat.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@MappedSuperclass
@Getter @Setter
public class AbstractEntity implements Serializable {
    private static final long serialVersionUID = -9067008980429974535L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
