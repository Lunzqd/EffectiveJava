package com.rgs.effectivejava.Section2;

import com.rgs.effectivejava.core.exception.ServiceException;
import com.rgs.effectivejava.entity.section2.DtoPoint;
import com.rgs.effectivejava.entity.section2.DtoPointColor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ComponentScan("com.rgs.effectivejava")
@Slf4j
public class Item10CommonTest {

    @Rule
    public ExpectedException thrown=ExpectedException.none();


    @Test(expected=NullPointerException.class)
    public void invalidTest1 () throws ServiceException{

        DtoPoint dtoPoint1=new DtoPoint(1,2);
        DtoPoint dtoPoint2=new DtoPoint(1,2);

        Assert.assertEquals(dtoPoint1,null);
        //Assert.assertEquals(dtoPoint2,dtoPoint1);
    }

    @Test(expected=ClassCastException.class)
    public void invalidTest2 () throws ServiceException{

        DtoPoint dtoPoint1=new DtoPoint(1,2);

        Assert.assertEquals(dtoPoint1,1);
        //Assert.assertEquals(dtoPoint2,dtoPoint1);
    }
}
