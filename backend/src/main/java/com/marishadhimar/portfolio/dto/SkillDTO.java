package com.marishadhimar.portfolio.dto;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class SkillDTO {
    @NotNull
    private String skillName;

    @NotNull
    private Integer percentage;
}
