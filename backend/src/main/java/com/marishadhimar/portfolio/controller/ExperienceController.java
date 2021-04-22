package com.marishadhimar.portfolio.controller;

import com.marishadhimar.portfolio.dto.ExperienceDTO;
import com.marishadhimar.portfolio.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experience")
public class ExperienceController {

    private ExperienceService experienceService;

    @Autowired
    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @RequestMapping(value = "/getExperience/{experienceId}", method = RequestMethod.GET)
    ResponseEntity<ExperienceDTO> getExperience(@PathVariable Long experienceId) {
        return new ResponseEntity<>(experienceService.getExperience(experienceId), HttpStatus.OK);
    }

    @RequestMapping(value = "/getAllExperience", method = RequestMethod.GET)
    ResponseEntity<List<ExperienceDTO>> getAllExperience() {
        return new ResponseEntity<>(experienceService.getAllExperiences(), HttpStatus.OK);
    }

    @RequestMapping(value = "/addExperience", method = RequestMethod.POST)
    ResponseEntity<ExperienceDTO> addExperience(@RequestBody ExperienceDTO experienceDTO) {
        return new ResponseEntity<>(experienceService.createExperience(experienceDTO), HttpStatus.OK);
    }

    @RequestMapping(value = "/updateExperience/{experienceId}", method = RequestMethod.PUT)
    ResponseEntity<ExperienceDTO> updateExperience(@RequestBody ExperienceDTO experienceDTO, @PathVariable Long experienceId) {
        return new ResponseEntity<>(experienceService.updateExperience(experienceId, experienceDTO), HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteExperience/{experienceId}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteExperience(@PathVariable Long experienceId) {
        experienceService.deleteExperience(experienceId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
