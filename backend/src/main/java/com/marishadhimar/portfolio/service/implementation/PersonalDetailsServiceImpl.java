package com.marishadhimar.portfolio.service.implementation;

import com.marishadhimar.portfolio.domain.PersonalDetails;
import com.marishadhimar.portfolio.dto.PersonalDetailsDTO;
import com.marishadhimar.portfolio.mapper.PersonalDetailsMapper;
import com.marishadhimar.portfolio.repository.PersonalDetailsRepository;
import com.marishadhimar.portfolio.service.PersonalDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class PersonalDetailsServiceImpl implements PersonalDetailsService {

    private PersonalDetailsRepository personalDetailsRepository;

    @Autowired
    public PersonalDetailsServiceImpl(PersonalDetailsRepository personalDetailsRepository) {
        this.personalDetailsRepository = personalDetailsRepository;
    }

    @Override
    public PersonalDetailsDTO getPersonalDetails(Long personalDetailsId) {
        Optional<PersonalDetails> personalDetails = personalDetailsRepository.findById(personalDetailsId);
        if(personalDetails.isPresent()) {
            return PersonalDetailsMapper.INSTANCE.toPersonalDetailsDTO(personalDetails.get());
        } else {
            throw new RuntimeException("PersonalDetails with id " + personalDetails + " was not found!");
        }
    }

    @Override
    public List<PersonalDetailsDTO> getAllPersonalDetails() {
        List<PersonalDetails> personalDetailsList = personalDetailsRepository.findAll();
        return PersonalDetailsMapper.INSTANCE.toPersonalDetailsDTOList(personalDetailsList);
    }

    @Override
    public PersonalDetailsDTO createPersonalDetails(PersonalDetailsDTO personalDetailsDTO) {
        PersonalDetails personalDetails = PersonalDetailsMapper.INSTANCE.toPersonalDetails(personalDetailsDTO);
        PersonalDetails persistedPersonalDetails = personalDetailsRepository.save(personalDetails);
        return PersonalDetailsMapper.INSTANCE.toPersonalDetailsDTO(persistedPersonalDetails);
    }

    @Override
    public PersonalDetailsDTO updatePersonalDetails(Long personalDetailsId, PersonalDetailsDTO personalDetailsDTO) {
        Optional<PersonalDetails> optionalPersonalDetails = personalDetailsRepository.findById(personalDetailsId);
        if (optionalPersonalDetails.isPresent()) {
            PersonalDetails personalDetails = optionalPersonalDetails.get();
            personalDetails.setFirstName(personalDetailsDTO.getFirstName());
            personalDetails.setLastName(personalDetailsDTO.getLastName());
            personalDetails.setEmail(personalDetailsDTO.getEmail());
            personalDetails.setAboutMe(personalDetailsDTO.getAboutMe());
            personalDetails.setAddress(personalDetailsDTO.getAddress());
            personalDetails.setAboutMe(personalDetailsDTO.getAboutMe());
            personalDetails.setMediaLinks(personalDetailsDTO.getMediaLinks());
            personalDetails.setPhoneNo(personalDetailsDTO.getPhoneNo());
            PersonalDetails persistedPersonalDetails = personalDetailsRepository.save(personalDetails);
            return PersonalDetailsMapper.INSTANCE.toPersonalDetailsDTO(persistedPersonalDetails);
        } else {
            throw new RuntimeException("PersonalDetails with id " + personalDetailsId + " was not found!");
        }
    }

    @Override
    public void deletePersonalDetails(Long personalDetailsId) {
        Optional<PersonalDetails> optionalPersonalDetails = personalDetailsRepository.findById(personalDetailsId);
        if (optionalPersonalDetails.isPresent()) {
            personalDetailsRepository.delete(optionalPersonalDetails.get());
        } else {
            throw new RuntimeException("PersonalDetails with id " + personalDetailsId + " was not found!");
        }
    }
}
