package com.marishadhimar.portfolio.mapper;

import com.marishadhimar.portfolio.domain.Skill;
import com.marishadhimar.portfolio.dto.SkillDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SkillMapper {
    SkillMapper INSTANCE = Mappers.getMapper(SkillMapper.class);

    @Mappings({
    })
    SkillDTO toSkillDTO(Skill skill);
    List<SkillDTO> toSkillDTOList(List<Skill> skillList);

    @Mappings({
    })
    Skill toSkill(SkillDTO skillDTO);
    List<Skill> toSkillList(List<SkillDTO> skillDTOList);
}
