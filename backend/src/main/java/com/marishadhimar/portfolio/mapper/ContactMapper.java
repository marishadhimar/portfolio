package com.marishadhimar.portfolio.mapper;

import com.marishadhimar.portfolio.domain.Contact;
import com.marishadhimar.portfolio.dto.ContactDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);

    @Mappings({})
    ContactDTO toContactDTO(Contact contact);

    @Mappings({})
    Contact toContact(ContactDTO contactDTO);
}
