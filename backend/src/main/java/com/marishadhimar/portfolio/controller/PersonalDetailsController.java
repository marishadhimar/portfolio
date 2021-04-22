package com.marishadhimar.portfolio.controller;

import com.marishadhimar.portfolio.dto.PersonalDetailsDTO;
import com.marishadhimar.portfolio.service.PersonalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personalDetails")
public class PersonalDetailsController {

    private PersonalDetailsService personalDetailsService;

    @Autowired
    public PersonalDetailsController(PersonalDetailsService personalDetailsService) {
        this.personalDetailsService = personalDetailsService;
    }

    @RequestMapping(value = "/getPersonalDetails/{personalDetailsId}", method = RequestMethod.GET)
    ResponseEntity<PersonalDetailsDTO> getPersonalDetails(@PathVariable Long personalDetailsId) {
        return new ResponseEntity<>(personalDetailsService.getPersonalDetails(personalDetailsId), HttpStatus.OK);
    }

    @RequestMapping(value = "/getAllPersonalDetails", method = RequestMethod.GET)
    ResponseEntity<List<PersonalDetailsDTO>> getAllPersonalDetails() {
        return new ResponseEntity<>(personalDetailsService.getAllPersonalDetails(), HttpStatus.OK);
    }

    @RequestMapping(value = "/addPersonalDetails", method = RequestMethod.POST)
    ResponseEntity<PersonalDetailsDTO> addPersonalDetails(@RequestBody PersonalDetailsDTO personalDetailsDTO) {
        return new ResponseEntity<>(personalDetailsService.createPersonalDetails(personalDetailsDTO), HttpStatus.OK);
    }

    @RequestMapping(value = "/updatePersonalDetails/{personalDetailsId}", method = RequestMethod.PUT)
    ResponseEntity<PersonalDetailsDTO> updatePersonalDetails(@RequestBody PersonalDetailsDTO personalDetailsDTO, @PathVariable Long personalDetailsId) {
        return new ResponseEntity<>(personalDetailsService.updatePersonalDetails(personalDetailsId, personalDetailsDTO), HttpStatus.OK);
    }

    @RequestMapping(value = "/deletePersonalDetails/{personalDetailsId}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deletePersonalDetails(@PathVariable Long personalDetailsId) {
        personalDetailsService.deletePersonalDetails(personalDetailsId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
