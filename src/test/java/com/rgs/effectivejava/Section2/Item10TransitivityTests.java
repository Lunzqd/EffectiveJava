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
public class Item10TransitivityTests {

    @Test
    public void invalidTest1 () throws ServiceException{


        DtoPointColor dtoPointColor1=new DtoPointColor(1,2,"Red");
        DtoPoint dtoPoint1=new DtoPoint(1,2);
        DtoPointColor dtoPointColor2=new DtoPointColor(1,2,"Red");

        Assert.assertEquals(dtoPointColor1,dtoPoint1);
        Assert.assertEquals(dtoPoint1,dtoPointColor2);
    }

    @Test
    public void invalidTest2 () throws ServiceException{


        DtoPointColor dtoPointColor1=new DtoPointColor(1,2,"Red");
        DtoPoint dtoPoint2=new DtoPoint(1,2);
        DtoPointColor dtoPointColor3=new DtoPointColor(1,2,"Blue");

        Assert.assertEquals(dtoPointColor1,dtoPoint2);
        Assert.assertEquals(dtoPoint2,dtoPointColor3);
        Assert.assertEquals(dtoPointColor1,dtoPointColor3);
    }

    /**
     * Correct test
     *
     * @throws ServiceException
     */
    @Test
    public void invalidTest3 () throws ServiceException{


        DtoPointColor dtoPointColor1=new DtoPointColor(1,2,"Red");
        DtoPoint dtoPoint2=new DtoPoint(1,2);
        DtoPointColor dtoPointColor3=new DtoPointColor(1,2,"Blue");

        Assert.assertNotEquals(dtoPointColor1,dtoPoint2);
        Assert.assertNotEquals(dtoPoint2,dtoPointColor3);
        Assert.assertNotEquals(dtoPointColor1,dtoPointColor3);
    }
}
