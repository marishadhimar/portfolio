package com.marishadhimar.portfolio.mapper;

import com.marishadhimar.portfolio.domain.Contact;
import com.marishadhimar.portfolio.dto.ContactDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);

    @Mappings({})
    ContactDTO toContactDTO(Contact contact);
    List<ContactDTO> toContactDTOList(List<Contact> contactList);

    @Mappings({})
    Contact toContact(ContactDTO contactDTO);
    List<Contact> toContactList(List<ContactDTO> contactDTOList);
}
