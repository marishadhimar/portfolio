package com.marishadhimar.portfolio.dto;

import com.marishadhimar.portfolio.domain.Address;
import com.sun.istack.NotNull;
import lombok.Data;

import java.util.Map;

@Data
public class PersonalDetailsDTO {
    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private Address address;

    @NotNull
    private String phoneNo;

    @NotNull
    private String email;

    private String aboutMe;

    private Map<String, String> mediaLinks;
}
