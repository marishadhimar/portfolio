package com.marishadhimar.portfolio.service;

import com.marishadhimar.portfolio.dto.EducationDTO;
import com.marishadhimar.portfolio.dto.ExperienceDTO;

import java.util.List;

public interface ExperienceService {
    ExperienceDTO getExperience(Long experienceId);

    List<ExperienceDTO> getAllExperiences();

    ExperienceDTO createExperience(ExperienceDTO experienceDTO);

    ExperienceDTO updateExperience(Long experienceId, ExperienceDTO experienceDTO);

    void deleteExperience(Long experienceId);
}
