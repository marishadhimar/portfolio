package com.marishadhimar.portfolio.mapper;

import com.marishadhimar.portfolio.domain.Skill;
import com.marishadhimar.portfolio.dto.SkillDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SkillMapper {
    SkillMapper INSTANCE = Mappers.getMapper(SkillMapper.class);

    @Mappings({
    })
    SkillDTO toSkillDTO(Skill skill);

    @Mappings({
    })
    Skill toSkill(SkillDTO skillDTO);
}
