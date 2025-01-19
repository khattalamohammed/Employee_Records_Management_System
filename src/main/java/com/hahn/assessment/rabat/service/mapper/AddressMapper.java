package com.hahn.assessment.rabat.service.mapper;

import com.hahn.assessment.rabat.dto.AddressDTO;
import com.hahn.assessment.rabat.model.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper extends GenericMapper<Address, AddressDTO> {
}
