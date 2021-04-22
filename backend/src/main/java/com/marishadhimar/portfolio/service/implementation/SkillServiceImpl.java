package com.marishadhimar.portfolio.service.implementation;

import com.marishadhimar.portfolio.domain.Skill;
import com.marishadhimar.portfolio.dto.SkillDTO;
import com.marishadhimar.portfolio.mapper.SkillMapper;
import com.marishadhimar.portfolio.repository.SkillRepository;
import com.marishadhimar.portfolio.service.SkillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class SkillServiceImpl implements SkillService {

    private SkillRepository skillRepository;

    @Autowired
    public SkillServiceImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public SkillDTO getSkill(Long skillId) {
        Optional<Skill> optionalSkill = skillRepository.findById(skillId);
        if (optionalSkill.isPresent()) {
            return SkillMapper.INSTANCE.toSkillDTO(optionalSkill.get());
        } else {
            throw new RuntimeException("Skill with id " + skillId + " was not found!");
        }
    }

    @Override
    public List<SkillDTO> getAllSkills() {
        List<Skill> skillList = skillRepository.findAll();
        return SkillMapper.INSTANCE.toSkillDTOList(skillList);
    }

    @Override
    public SkillDTO createSkill(SkillDTO skillDTO) {
        Skill skill = SkillMapper.INSTANCE.toSkill(skillDTO);
        Skill persistedSkill = skillRepository.save(skill);
        return SkillMapper.INSTANCE.toSkillDTO(persistedSkill);
    }

    @Override
    public SkillDTO updateSkill(Long skillId, SkillDTO skillDTO) {
        Optional<Skill> optionalSkill = skillRepository.findById(skillId);
        if (optionalSkill.isPresent()) {
            Skill skill = optionalSkill.get();
            skill.setPercentage(skillDTO.getPercentage());
            skill.setSkillName(skillDTO.getSkillName());
            Skill persistedSkill = skillRepository.save(skill);
            return SkillMapper.INSTANCE.toSkillDTO(persistedSkill);
        } else {
            throw new RuntimeException("Skill with id " + skillId + " was not found!");
        }
    }

    @Override
    public void deleteSkill(Long skillId) {
        Optional<Skill> optionalSkill = skillRepository.findById(skillId);
        if (optionalSkill.isPresent()) {
            skillRepository.delete(optionalSkill.get());
        } else {
            throw new RuntimeException("Skill with id " + skillId + " was not found!");
        }
    }
}
