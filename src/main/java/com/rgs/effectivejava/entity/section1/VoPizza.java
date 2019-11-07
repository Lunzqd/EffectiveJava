package com.rgs.effectivejava.entity.section1;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class VoPizza implements Serializable {

    /**
     * 1 for NYPizza
     * 2 for Calzone
     */
    private Integer pizzaType;

    private Integer size;

    private Boolean sourceInside;

    private Set<String> toppings;
}
