package com.marishadhimar.portfolio.repository;

import com.marishadhimar.portfolio.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
