package com.rgs.effectivejava.interfaces.section1;

import com.rgs.effectivejava.entity.section1.DtoNutrition;
import com.rgs.effectivejava.entity.section1.DtoPizza;
import com.rgs.effectivejava.entity.section1.VoNutrition;
import com.rgs.effectivejava.entity.section1.VoPizza;

/**
 * The interfaces interface for item2
 *
 * @author mz
 * @date 2019-11-06
 */
public interface Item2Service {

    /**
     * Build nutrition based on the parameter user passed in
     * @param voNutrition
     * @return
     */
    DtoNutrition BuildNutrition(VoNutrition voNutrition);

    /**
     * Build the pizza based on the parameter user passed in
     * @param voPizza
     * @return
     */
    DtoPizza BuildPizza(VoPizza voPizza);
}
