package com.marishadhimar.portfolio.mapper;

import com.marishadhimar.portfolio.domain.Education;
import com.marishadhimar.portfolio.dto.EducationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EducationMapper {
    EducationMapper INSTANCE = Mappers.getMapper(EducationMapper.class);

    @Mappings({})
    EducationDTO toEducationDTO(Education education);
    List<EducationDTO> toEducationDTOList(List<Education> educationList);

    @Mappings({})
    Education toEducation(EducationDTO educationDTO);
    List<Education> toEducationList(List<EducationDTO> educationDTOList);
}
