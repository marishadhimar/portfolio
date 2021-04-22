package com.marishadhimar.portfolio.service;

import com.marishadhimar.portfolio.dto.ContactDTO;
import com.marishadhimar.portfolio.dto.EducationDTO;

import java.util.List;

public interface EducationService {
    EducationDTO getEducation(Long educationId);

    List<EducationDTO> getAllEducation();

    EducationDTO createEducation(EducationDTO educationDTO);

    EducationDTO updateEducation(Long educationId, EducationDTO educationDTO);

    void deleteEducation(Long educationId);
}
