package com.rgs.effectivejava.Section1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rgs.effectivejava.core.exception.ServiceException;
import com.rgs.effectivejava.entity.section1.DtoNutrition;
import com.rgs.effectivejava.entity.section1.DtoPizza;
import com.rgs.effectivejava.entity.section1.VoNutrition;
import com.rgs.effectivejava.entity.section1.VoPizza;
import com.rgs.effectivejava.interfaces.section1.Item2Service;
import com.rgs.effectivejava.serviceimpl.section1.Item2ServiceImpl;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@RunWith(SpringRunner.class)
@ComponentScan("com.rgs.effectivejava")
public class Item2Tests {

    @InjectMocks
    private Item2ServiceImpl item2Service;

    @Rule
    public ExpectedException thrown=ExpectedException.none();

    @Test(expected = ServiceException.class)
    public void invalidTest1 () throws ServiceException{

        VoNutrition voNutrition=new VoNutrition();
        voNutrition.setServingSize(null);
        item2Service.BuildNutrition(voNutrition);
    }

    @Test
    public void invalidTest2 () throws ServiceException{

        VoNutrition voNutrition=new VoNutrition();
        voNutrition.setServingSize(50);
        voNutrition.setServingMeasurement(null);
        thrown.expect(ServiceException.class);
        thrown.expectMessage("Serving should have measurement");
        item2Service.BuildNutrition(voNutrition);
    }

    @Test
    public void invalidTest3 (){


        ServiceException exception=assertThrows(ServiceException.class,()->{
            item2Service.BuildNutrition(null);
        });

        Assert.assertNotNull(exception);
    }

    @Test(expected = ServiceException.class)
    public void invalidTest4 () throws ServiceException{

        VoPizza voPizza=new VoPizza();
        voPizza.setPizzaType(0);
        item2Service.BuildPizza(voPizza);
    }

    @Test
    public void invalidTest5 () throws ServiceException{

        VoPizza voPizza=new VoPizza();
        voPizza.setPizzaType(1);
        voPizza.setSize(6);

        Set<String> lstTopping=new HashSet<>();
        lstTopping.add("Onion");
        lstTopping.add("Cheese");
        voPizza.setToppings(lstTopping);
        DtoPizza dtoPizza=item2Service.BuildPizza(voPizza);
        String pizzaJson=JSON.toJSONString(dtoPizza);
        Assert.assertNotNull(dtoPizza);
    }

    @Test
    public void invalidTest6 (){


        ServiceException exception=assertThrows(ServiceException.class,()->{
            item2Service.BuildPizza(null);
        });

        Assert.assertNotNull(exception);
    }

    @Test
    public void invalidTest7 () throws ServiceException{

        VoPizza voPizza=new VoPizza();
        voPizza.setPizzaType(2);
        voPizza.setSize(6);
        voPizza.setSourceInside(true);

        Set<String> lstTopping=new HashSet<>();
        lstTopping.add("Onion");
        lstTopping.add("Cheese");
        voPizza.setToppings(lstTopping);
        DtoPizza dtoPizza=item2Service.BuildPizza(voPizza);
        String pizzaJson=JSON.toJSONString(dtoPizza);
        Assert.assertNotNull(dtoPizza);
    }
}
