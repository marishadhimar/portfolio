package com.marishadhimar.portfolio.dto;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class ProjectDTO {
    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private String technology;

    private byte[] photo;

    private String projectLink;

    private String githubLink;
}
