package com.rgs.effectivejava.controller.Section1;

import com.alibaba.fastjson.JSON;
import com.rgs.effectivejava.core.exception.ServiceException;
import com.rgs.effectivejava.core.interaction.ServiceApiResult;
import com.rgs.effectivejava.entity.section1.*;
import com.rgs.effectivejava.interfaces.section1.Item2Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Item 2: Consider a builder when faced with many constructor parameters
 *
 * 1: 适用于参数过多的构造函数
 * 2：这些参数中有一些是必填的，有一些是非必填的
 *
 * 不足：
 * 1：不推荐在bean中使用，因为java bean的生成必须要有空的构造函数，而一旦该方法用以生成单例，那么他就不会有无参构造函数
 *
 * 一般用来做多参对象的构造
 */
@RestController
@Api(tags="Creating and Destroying Objects", value="Section1")
@RequestMapping("section1")
public class Item2Controller {

    @Autowired
    Item2Service item2Service;


    @PostMapping("/item2/nutrition")
    @ApiOperation(value = "item2/nutrition")
    public ServiceApiResult<DtoNutrition> GetNutrition(@RequestBody VoNutrition model){

        ServiceApiResult result;
        try{

            DtoNutrition dtoNutrition=item2Service.BuildNutrition(model);
            result=ServiceApiResult.ok(dtoNutrition);

        }
        catch(ServiceException ex){
            result=ServiceApiResult.error(ex.getMsg());
        }
        catch(Exception ex){
            result=ServiceApiResult.error(ex.getMessage());
        }
        return result;
    }

    @PostMapping("/item2/pizza")
    @ApiOperation(value = "item2/pizza")
    public ServiceApiResult<String> GetPizza(@RequestBody VoPizza model){

        ServiceApiResult result;
        try{

            DtoPizza dtoPizza=item2Service.BuildPizza(model);
            String pizzaJson=JSON.toJSONString(dtoPizza);
            result=ServiceApiResult.ok(pizzaJson);

        }
        catch(ServiceException ex){
            result=ServiceApiResult.error(ex.getMsg());
        }
        catch(Exception ex){
            result=ServiceApiResult.error(ex.getMessage());
        }
        return result;
    }
}

