package com.rgs.effectivejava.entity.section1;

import lombok.Data;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;
import java.util.Date;
import java.util.EnumSet;

@Data
/**
 * The parent class of animal
 * which specify the generic properties of animal
 */
public class DtoAnimal implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The name of animal
     */
    private String animalName;

    /**
     * The species of animal
     * e.g. Cat, Dog....
     */
    private String species;

    /**
     * The age of animal
     */
    private Integer age;


    /**
     * The date of birth of animal
     */
    private Date dateOfBirth;

    /**
     * @return the summary properties of animal with the format of JSON
     */
    @Override
    public String toString(){

        return JSON.toJSONString(this);
    }

}
