package com.marishadhimar.portfolio.controller;

import com.marishadhimar.portfolio.dto.ProjectDTO;
import com.marishadhimar.portfolio.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping(value = "/getProject/{projectId}", method = RequestMethod.GET)
    ResponseEntity<ProjectDTO> getProject(@PathVariable Long projectId) {
        return new ResponseEntity<>(projectService.getProject(projectId), HttpStatus.OK);
    }

    @RequestMapping(value = "/getAllProjects", method = RequestMethod.GET)
    ResponseEntity<List<ProjectDTO>> getAllProjects() {
        return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
    }

    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
    ResponseEntity<ProjectDTO> addProject(@RequestBody ProjectDTO projectDTO) {
        return new ResponseEntity<>(projectService.createProject(projectDTO), HttpStatus.OK);
    }

    @RequestMapping(value = "/updateProject/{projectId}", method = RequestMethod.PUT)
    ResponseEntity<ProjectDTO> updateProject(@RequestBody ProjectDTO projectDTO, @PathVariable Long projectId) {
        return new ResponseEntity<>(projectService.updateProject(projectId, projectDTO), HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteProject/{projectId}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteProject(@PathVariable Long projectId) {
        projectService.deleteProject(projectId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
