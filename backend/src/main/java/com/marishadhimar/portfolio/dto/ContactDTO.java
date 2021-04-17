package com.marishadhimar.portfolio.dto;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class ContactDTO {
    @NotNull
    private String name;

    @NotNull
    private String subject;

    @NotNull
    private String email;
}
