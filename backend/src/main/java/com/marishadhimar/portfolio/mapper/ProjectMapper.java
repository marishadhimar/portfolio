package com.marishadhimar.portfolio.mapper;

import com.marishadhimar.portfolio.domain.Project;
import com.marishadhimar.portfolio.dto.PersonalDetailsDTO;
import com.marishadhimar.portfolio.dto.ProjectDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    @Mappings({})
    ProjectDTO toProjectDTO(Project project);

    @Mappings({})
    Project toProject(ProjectDTO projectDTO);
}
