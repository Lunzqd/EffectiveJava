package com.rgs.effectivejava.serviceimpl.section1;

import com.rgs.effectivejava.core.exception.ServiceException;
import com.rgs.effectivejava.entity.section1.*;
import com.rgs.effectivejava.interfaces.section1.Item2Service;
import org.springframework.stereotype.Service;

/**
 * The implementation service of item2
 *
 * @author mz
 * @date 2019-11-07
 */
@Service
public class Item2ServiceImpl implements Item2Service {


    /**
     * Build nutrition based on the parameter user passed in
     *
     * @param voNutrition
     * @return
     */
    @Override
    public DtoNutrition BuildNutrition(VoNutrition voNutrition) {

        DtoNutrition dtoNutrition=null;
        if(voNutrition==null){
            throw new ServiceException("nutrition object should not be null or empty");
        }
        try{

            dtoNutrition=new DtoNutrition.Builder(voNutrition.getServingSize(),voNutrition.getServingMeasurement())
                    .calories(voNutrition.getCalories())
                    .carbohydrate(voNutrition.getCarbohydrate())
                    .fat(voNutrition.getFat())
                    .sodium(voNutrition.getSodium())
                    .build();
        }
        catch(ServiceException ex){
            throw ex;
        }
        catch (Exception ex){
            throw new ServiceException(ex.getMessage(),ex);
        }
        return dtoNutrition;
    }

    /**
     * Build the pizza based on the parameter user passed in
     *
     * @param voPizza
     * @return
     */
    @Override
    public DtoPizza BuildPizza(VoPizza voPizza) {

        DtoPizza pizza=null;
        if(voPizza==null){
            throw new ServiceException("pizza object should not be null or empty");
        }
        if(voPizza.getPizzaType()==null){
            throw new ServiceException("Please specified the pizza type");
        }

        try{

            switch (voPizza.getPizzaType()){

                case 1:
                    pizza=this.buildNYPizza(voPizza);
                    break;
                case 2:
                    pizza=this.buildCalzone(voPizza);
                    break;
                default:
                    throw new ServiceException("Please specified correct type");
            }
        }
        catch(ServiceException ex){
            throw ex;
        }
        catch (Exception ex){
            throw new ServiceException(ex.getMessage(),ex);
        }
        return pizza;
    }

    private DtoPizza buildNYPizza(VoPizza voPizza){

        DtoNyPizza.Builder builder=new DtoNyPizza.Builder(voPizza.getSize());
        for (String topping:voPizza.getToppings()){
            builder=builder.addTopping(topping);
        }
        return builder.build();
    }

    private DtoPizza buildCalzone(VoPizza voPizza){

        DtoCalzone.Builder builder=new DtoCalzone.Builder(voPizza.getSize());
        for (String topping:voPizza.getToppings()){
            builder=builder.addTopping(topping);
        }
        builder.sourceInside(voPizza.getSourceInside());
        return builder.build();
    }
}
