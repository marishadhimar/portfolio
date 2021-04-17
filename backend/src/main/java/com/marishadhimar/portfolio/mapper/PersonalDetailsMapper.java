package com.marishadhimar.portfolio.mapper;

import com.marishadhimar.portfolio.domain.PersonalDetails;
import com.marishadhimar.portfolio.dto.PersonalDetailsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonalDetailsMapper {
    PersonalDetailsMapper INSTANCE = Mappers.getMapper(PersonalDetailsMapper.class);

    @Mappings({})
    PersonalDetailsDTO toPersonalDetailsDTO(PersonalDetails personalDetails);

    @Mappings({})
    PersonalDetails toPersonalDetails(PersonalDetailsDTO personalDetailsDTO);
}
