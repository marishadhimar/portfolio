package com.marishadhimar.portfolio.service;

import com.marishadhimar.portfolio.dto.ExperienceDTO;
import com.marishadhimar.portfolio.dto.PersonalDetailsDTO;

import java.util.List;

public interface PersonalDetailsService {
    PersonalDetailsDTO getPersonalDetails(Long personalDetailsId);

    List<PersonalDetailsDTO> getAllPersonalDetails();

    PersonalDetailsDTO createPersonalDetails(PersonalDetailsDTO personalDetailsDTO);

    PersonalDetailsDTO updatePersonalDetails(Long personalDetailsId, PersonalDetailsDTO personalDetailsDTO);

    void deletePersonalDetails(Long personalDetailsId);
}
