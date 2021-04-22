package com.marishadhimar.portfolio.service;

import com.marishadhimar.portfolio.dto.ProjectDTO;
import com.marishadhimar.portfolio.dto.SkillDTO;

import java.util.List;

public interface SkillService {
    SkillDTO getSkill(Long skillId);

    List<SkillDTO> getAllSkills();

    SkillDTO createSkill(SkillDTO skillDTO);

    SkillDTO updateSkill(Long skillId, SkillDTO skillDTO);

    void deleteSkill(Long skillId);
}
