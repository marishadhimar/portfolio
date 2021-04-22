package com.marishadhimar.portfolio.controller;

import com.marishadhimar.portfolio.dto.EducationDTO;
import com.marishadhimar.portfolio.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/education")
public class EducationController {

    private EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @RequestMapping(value = "/getEducation/{educationId}", method = RequestMethod.GET)
    ResponseEntity<EducationDTO> getEducation(@PathVariable Long educationId) {
        return new ResponseEntity<>(educationService.getEducation(educationId), HttpStatus.OK);
    }

    @RequestMapping(value = "/getAllEducation", method = RequestMethod.GET)
    ResponseEntity<List<EducationDTO>> getAllEducation() {
        return new ResponseEntity<>(educationService.getAllEducation(), HttpStatus.OK);
    }

    @RequestMapping(value = "/addEducation", method = RequestMethod.POST)
    ResponseEntity<EducationDTO> addEducation(@RequestBody EducationDTO educationDTO) {
        return new ResponseEntity<>(educationService.createEducation(educationDTO), HttpStatus.OK);
    }

    @RequestMapping(value = "/updateEducation/{educationId}", method = RequestMethod.PUT)
    ResponseEntity<EducationDTO> updateEducation(@RequestBody EducationDTO educationDTO, @PathVariable Long educationId) {
        return new ResponseEntity<>(educationService.updateEducation(educationId, educationDTO), HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteEducation/{educationId}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteEducation(@PathVariable Long educationId) {
        educationService.deleteEducation(educationId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
