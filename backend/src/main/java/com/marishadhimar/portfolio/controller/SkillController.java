package com.marishadhimar.portfolio.controller;

import com.marishadhimar.portfolio.dto.SkillDTO;
import com.marishadhimar.portfolio.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skill")
public class SkillController {

    private SkillService skillService;

    @Autowired
    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @RequestMapping(value = "/getSkill/{skillId}", method = RequestMethod.GET)
    ResponseEntity<SkillDTO> getSkill(@PathVariable Long skillId) {
        return new ResponseEntity<>(skillService.getSkill(skillId), HttpStatus.OK);
    }

    @RequestMapping(value = "/getAllSkills", method = RequestMethod.GET)
    ResponseEntity<List<SkillDTO>> getSkills() {
        return new ResponseEntity<>(skillService.getAllSkills(), HttpStatus.OK);
    }

    @RequestMapping(value = "/addSkill", method = RequestMethod.POST)
    ResponseEntity<SkillDTO> addSkill(@RequestBody SkillDTO skillDTO) {
        return new ResponseEntity<>(skillService.createSkill(skillDTO), HttpStatus.OK);
    }

    @RequestMapping(value = "/updateSkill/{skillId}", method = RequestMethod.PUT)
    ResponseEntity<SkillDTO> updateSkill(@RequestBody SkillDTO skillDTO, @PathVariable Long skillId) {
        return new ResponseEntity<>(skillService.updateSkill(skillId, skillDTO), HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteSkill/{skillId}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteSkill(@PathVariable Long skillId) {
        skillService.deleteSkill(skillId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
