package com.rgs.effectivejava.entity.section3;

import lombok.Data;

import java.util.Date;

@Data
public class VoUser {

    private String id;

    private String name;

    private String gender;

    private Date dateOfBirth;
}
