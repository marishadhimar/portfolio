package com.marishadhimar.portfolio.dto;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class EducationDTO {
    @NotNull
    private String courseName;

    @NotNull
    private String coursePlatform;

    @NotNull
    private String score;

    @NotNull
    private Integer fromYear;

    @NotNull
    private Integer toYear;
}
