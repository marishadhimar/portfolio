package com.marishadhimar.portfolio.service.implementation;

import com.marishadhimar.portfolio.domain.Experience;
import com.marishadhimar.portfolio.dto.ExperienceDTO;
import com.marishadhimar.portfolio.mapper.ExperienceMapper;
import com.marishadhimar.portfolio.repository.ExperienceRepository;
import com.marishadhimar.portfolio.service.ExperienceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class ExperienceServiceImpl implements ExperienceService {

    private ExperienceRepository experienceRepository;

    @Autowired
    public ExperienceServiceImpl(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @Override
    public ExperienceDTO getExperience(Long experienceId) {
        Optional<Experience> optionalExperience = experienceRepository.findById(experienceId);
        if (optionalExperience.isPresent()) {
            return ExperienceMapper.INSTANCE.toExperienceDTO(optionalExperience.get());
        } else {
            throw new RuntimeException("Experience with id " + experienceId + " was not found!");
        }
    }

    @Override
    public List<ExperienceDTO> getAllExperiences() {
        List<Experience> experienceList = experienceRepository.findAll();
        return ExperienceMapper.INSTANCE.toExperienceDTOList(experienceList);
    }

    @Override
    public ExperienceDTO createExperience(ExperienceDTO experienceDTO) {
        Experience experience = ExperienceMapper.INSTANCE.toExperience(experienceDTO);
        Experience persistedExperience = experienceRepository.save(experience);
        return ExperienceMapper.INSTANCE.toExperienceDTO(persistedExperience);
    }

    @Override
    public ExperienceDTO updateExperience(Long experienceId, ExperienceDTO experienceDTO) {
        Optional<Experience> optionalExperience = experienceRepository.findById(experienceId);
        if (optionalExperience.isPresent()) {
            Experience experience = optionalExperience.get();
            experience.setCompanyName(experienceDTO.getCompanyName());
            experience.setDesignation(experienceDTO.getDesignation());
            experience.setExperience(experienceDTO.getExperience());
            experience.setFromYear(experienceDTO.getFromYear());
            experience.setToYear(experienceDTO.getToYear());
            Experience persistedExperience = experienceRepository.save(experience);
            return ExperienceMapper.INSTANCE.toExperienceDTO(persistedExperience);
        } else {
            throw new RuntimeException("Experience with id " + experienceId + " was not found!");
        }
    }

    @Override
    public void deleteExperience(Long experienceId) {
        Optional<Experience> optionalExperience = experienceRepository.findById(experienceId);
        if (optionalExperience.isPresent()) {
            experienceRepository.delete(optionalExperience.get());
        } else {
            throw new RuntimeException("Experience with id " + experienceId + " was not found!");
        }
    }
}
