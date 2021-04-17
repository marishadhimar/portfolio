package com.marishadhimar.portfolio.mapper;

import com.marishadhimar.portfolio.domain.Experience;
import com.marishadhimar.portfolio.dto.ExperienceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ExperienceMapper {
    ExperienceMapper INSTANCE = Mappers.getMapper(ExperienceMapper.class);

    @Mappings({})
    ExperienceDTO toExperienceDTO(Experience experience);

    @Mappings({})
    Experience toExperience(ExperienceDTO experienceDTO);
}
