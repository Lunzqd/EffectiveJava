package com.rgs.effectivejava.entity.section3;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class DtoLombok {

    private String name;

    private Integer age;

    @Setter(AccessLevel.PRIVATE)
    private String tag;

    public DtoLombok(String tag){
        this.tag=tag;
    }
}
