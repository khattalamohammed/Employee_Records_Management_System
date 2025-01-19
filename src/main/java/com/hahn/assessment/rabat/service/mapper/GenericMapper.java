package com.hahn.assessment.rabat.service.mapper;

public interface GenericMapper<E, D> {

    D toDto(E e);
    E toEntity(D d);
}
