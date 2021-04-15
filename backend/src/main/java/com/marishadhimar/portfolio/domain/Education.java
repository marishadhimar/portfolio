package com.marishadhimar.portfolio.domain;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_education")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "course_name")
    private String courseName;

    // school clg or online portal
    @NotNull
    @Column(name = "course_platform")
    private String coursePlatform;

    @NotNull
    private String score;

    //TODO: check which field is needed
    @NotNull
    @Column(name = "from_year")
    private Integer fromYear;

    @NotNull
    @Column(name = "to_year")
    private Integer toYear;
}
