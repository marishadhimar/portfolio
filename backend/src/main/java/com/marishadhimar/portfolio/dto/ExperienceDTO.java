package com.marishadhimar.portfolio.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import java.time.YearMonth;

@Data
public class ExperienceDTO {
    @NotNull
    private YearMonth fromYear;

    @NotNull
    private YearMonth toYear;

    @NotNull
    private String companyName;

    @NotNull
    private Integer experience;

    @NotNull
    private String designation;
}
