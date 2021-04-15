package com.marishadhimar.portfolio.domain;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class Address {

    @NotNull
    private String addressLine1;

    private String addressLine2;

    private String city;

    @NotNull
    private String state;

}
