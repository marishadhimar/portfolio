package com.marishadhimar.portfolio.service.implementation;

import com.marishadhimar.portfolio.domain.Education;
import com.marishadhimar.portfolio.dto.EducationDTO;
import com.marishadhimar.portfolio.mapper.EducationMapper;
import com.marishadhimar.portfolio.repository.EducationRepository;
import com.marishadhimar.portfolio.service.EducationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class EducationServiceImpl implements EducationService {

    private EducationRepository educationRepository;

    @Autowired
    public EducationServiceImpl(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    @Override
    public EducationDTO getEducation(Long educationId) {
        Optional<Education> optionalEducation = educationRepository.findById(educationId);
        if (optionalEducation.isPresent()) {
            return EducationMapper.INSTANCE.toEducationDTO(optionalEducation.get());
        } else {
            throw new RuntimeException("Education with id " + educationId + " was not found!");
        }
    }

    @Override
    public List<EducationDTO> getAllEducation() {
        List<Education> educationList = educationRepository.findAll();
        return EducationMapper.INSTANCE.toEducationDTOList(educationList);
    }

    @Override
    public EducationDTO createEducation(EducationDTO educationDTO) {
        Education education = EducationMapper.INSTANCE.toEducation(educationDTO);
        Education persistedEducation = educationRepository.save(education);
        return EducationMapper.INSTANCE.toEducationDTO(persistedEducation);
    }

    @Override
    public EducationDTO updateEducation(Long educationId, EducationDTO educationDTO) {
        Optional<Education> optionalEducation = educationRepository.findById(educationId);
        if (optionalEducation.isPresent()) {
            Education education = optionalEducation.get();
            education.setCourseName(educationDTO.getCourseName());
            education.setCoursePlatform(educationDTO.getCoursePlatform());
            education.setScore(educationDTO.getScore());
            education.setFromYear(educationDTO.getFromYear());
            education.setToYear(educationDTO.getToYear());
            Education persistedEducation = educationRepository.save(education);
            return EducationMapper.INSTANCE.toEducationDTO(persistedEducation);
        } else {
            throw new RuntimeException("Education with id " + educationId + " was not found!");
        }
    }

    @Override
    public void deleteEducation(Long educationId) {
        Optional<Education> optionalEducation = educationRepository.findById(educationId);
        if (optionalEducation.isPresent()) {
            educationRepository.delete(optionalEducation.get());
        } else {
            throw new RuntimeException("Education with id " + educationId + " was not found!");
        }
    }
}
