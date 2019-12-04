package com.rgs.effectivejava.entity.section3;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.Date;

@Data
public class DtoUser {

    private String id;

    private String name;

    private String gender;

    private Date dateOfBirth;

    @Setter(AccessLevel.PRIVATE)
    private Integer age;
}
