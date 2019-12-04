package com.rgs.effectivejava.controller.Section3;

import com.rgs.effectivejava.core.exception.ServiceException;
import com.rgs.effectivejava.core.interaction.ServiceApiResult;
import com.rgs.effectivejava.entity.section1.DtoAnimal;
import com.rgs.effectivejava.entity.section1.DtoNewAnimal;
import com.rgs.effectivejava.entity.section3.DtoLombok;
import com.rgs.effectivejava.interfaces.section3.Item16Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags="Class and Interface", value="Section3")
@RequestMapping("section3")
public class Item16Controller {

    @Autowired
    Item16Service item16Service;

    @GetMapping("/item16")
    @ApiOperation(value = "item16")
    public ServiceApiResult<String> Getitem16(){

        ServiceApiResult<String> result;
        try{

            result=new ServiceApiResult<>();
            DtoLombok dtoLombok=item16Service.getLombokExample();
            result.setData(dtoLombok.toString());
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
