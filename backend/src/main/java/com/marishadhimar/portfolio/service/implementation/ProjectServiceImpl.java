package com.marishadhimar.portfolio.service.implementation;

import com.marishadhimar.portfolio.domain.Project;
import com.marishadhimar.portfolio.dto.ProjectDTO;
import com.marishadhimar.portfolio.mapper.ProjectMapper;
import com.marishadhimar.portfolio.repository.ProjectRepository;
import com.marishadhimar.portfolio.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
    }

    @Override
    public ProjectDTO getProject(Long projectId) {
        Optional<Project> optionalProject = projectRepository.findById(projectId);
        if (optionalProject.isPresent()) {
            return ProjectMapper.INSTANCE.toProjectDTO(optionalProject.get());
        } else {
            throw new RuntimeException("Project with id " + projectId + " was not found!");
        }
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        List<Project> projectList = projectRepository.findAll();
        return ProjectMapper.INSTANCE.toProjectDTOList(projectList);
    }

    @Override
    public ProjectDTO createProject(ProjectDTO projectDTO) {
        Project project = ProjectMapper.INSTANCE.toProject(projectDTO);
        Project persistedProject = projectRepository.save(project);
        return ProjectMapper.INSTANCE.toProjectDTO(persistedProject);
    }

    @Override
    public ProjectDTO updateProject(Long projectId, ProjectDTO projectDTO) {
        Optional<Project> optionalProject = projectRepository.findById(projectId);
        if (optionalProject.isPresent()) {
            Project project = optionalProject.get();
            project.setDescription(projectDTO.getDescription());
            project.setGithubLink(projectDTO.getGithubLink());
            project.setPhoto(projectDTO.getPhoto());
            project.setProjectLink(projectDTO.getProjectLink());
            project.setTechnology(projectDTO.getTechnology());
            project.setTitle(projectDTO.getTitle());
            Project persistedProject = projectRepository.save(project);
            return ProjectMapper.INSTANCE.toProjectDTO(persistedProject);
        } else {
            throw new RuntimeException("Project with id " + projectId + " was not found!");
        }
    }

    @Override
    public void deleteProject(Long projectId) {
        Optional<Project> optionalProject = projectRepository.findById(projectId);
        if (optionalProject.isPresent()) {
            projectRepository.delete(optionalProject.get());
        } else {
            throw new RuntimeException("Project with id " + projectId + " was not found!");
        }
    }
}
