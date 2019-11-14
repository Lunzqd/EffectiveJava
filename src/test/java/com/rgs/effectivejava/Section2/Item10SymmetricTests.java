package com.rgs.effectivejava.Section2;

import com.rgs.effectivejava.core.exception.ServiceException;
import com.rgs.effectivejava.entity.section2.DtoPoint;
import com.rgs.effectivejava.entity.section2.DtoPointColor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;



@SpringBootTest
@RunWith(SpringRunner.class)
@ComponentScan("com.rgs.effectivejava")
@Slf4j
public class Item10SymmetricTests {


    /**
     * Symmetric test
     * @throws ServiceException
     */
    @Test
    public void invalidTest1 () throws ServiceException{

        DtoPoint dtoPoint1=new DtoPoint(1,2);
        DtoPoint dtoPoint2=new DtoPoint(1,2);

        Assert.assertEquals(dtoPoint1,dtoPoint2);
        Assert.assertEquals(dtoPoint2,dtoPoint1);
    }

    /**
     * Symmetric test
     * @throws ServiceException
     */
    @Test
    public void invalidTest2 () throws ServiceException{

        DtoPointColor dtoPointColor1=new DtoPointColor(1,2,"Red");
        DtoPointColor dtoPointColor2=new DtoPointColor(1,2,"Red");

        Assert.assertEquals(dtoPointColor1,dtoPointColor2);
        Assert.assertEquals(dtoPointColor2,dtoPointColor1);
    }

    @Test
    public void invalidTest3 (){

        DtoPoint dtoPoint1=new DtoPoint(1,2);
        DtoPointColor dtoPointColor1=new DtoPointColor(1,2);

        Assert.assertEquals(dtoPoint1,dtoPointColor1);
        Assert.assertEquals(dtoPointColor1,dtoPoint1);

        //Assert.assertNotEquals(dtoPoint1,dtoPointColor1);
        //Assert.assertNotEquals(dtoPointColor1,dtoPoint1);
    }
}

