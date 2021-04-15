package com.marishadhimar.portfolio.domain;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.time.YearMonth;

@Data
@Entity
@Table(name = "t_experience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "from_year")
    private YearMonth fromYear;

    @NotNull
    @Column(name = "to_year")
    private YearMonth toYear;

    @NotNull
    @Column(name = "company_name")
    private String companyName;

    @NotNull
    private Integer experience;

    @NotNull
    private String designation;
}
