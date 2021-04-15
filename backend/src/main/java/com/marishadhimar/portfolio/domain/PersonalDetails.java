package com.marishadhimar.portfolio.domain;

import com.sun.istack.NotNull;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Entity
@Data
@TypeDef(name = "jsonb",
        typeClass = JsonBinaryType.class)
@Table(name = "t_personal_details")
public class PersonalDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private Address address;

    @NotNull
    @Column(name = "phone_no")
    private String phoneNo;

    @NotNull
    private String email;

    @Column(name = "about_me")
    private String aboutMe;

    @Type(type = "jsonb")
    @Column(name = "media_links", columnDefinition = "jsonb")
    private String mediaLinks;
}
