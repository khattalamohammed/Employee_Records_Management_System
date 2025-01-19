package com.hahn.assessment.rabat.service.mapper;

import com.hahn.assessment.rabat.dto.ContactDTO;
import com.hahn.assessment.rabat.model.Contact;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper extends GenericMapper<Contact, ContactDTO> {
}
