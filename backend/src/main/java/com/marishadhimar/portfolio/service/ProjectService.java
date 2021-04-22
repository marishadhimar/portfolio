package com.marishadhimar.portfolio.service;

import com.marishadhimar.portfolio.dto.PersonalDetailsDTO;
import com.marishadhimar.portfolio.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {
    ProjectDTO getProject(Long projectId);

    List<ProjectDTO> getAllProjects();

    ProjectDTO createProject(ProjectDTO projectDTO);

    ProjectDTO updateProject(Long projectId, ProjectDTO projectDTO);

    void deleteProject(Long projectId);
}
