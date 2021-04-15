package com.marishadhimar.portfolio.domain;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private String technology;

    private byte[] photo;

    @Column(name = "project_link")
    private String projectLink;

    @Column(name = "github_link")
    private String githubLink;
}
