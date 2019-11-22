package com.rgs.effectivejava.Section2;


import com.rgs.effectivejava.core.exception.ServiceException;
import com.rgs.effectivejava.entity.section2.DtoArea;
import com.rgs.effectivejava.entity.section2.DtoArea1;
import com.rgs.effectivejava.entity.section2.DtoCube;
import com.rgs.effectivejava.entity.section2.DtoPoint;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@ComponentScan("com.rgs.effectivejava")
@Slf4j
public class Item14Tests {

    @Rule
    public ExpectedException thrown=ExpectedException.none();

    @Test(expected= ServiceException.class)
    public void invalidTest1() throws ServiceException{

        DtoArea dtoArea=new DtoArea(null,1);
    }

    @Test(expected= NullPointerException.class)
    public void invalidTest2() throws NullPointerException{

        DtoArea dtoArea=new DtoArea(1,1);
        dtoArea.compareTo(null);
    }

    @Test(expected= ClassCastException.class)
    public void invalidTest3() throws ClassCastException{

        DtoArea dtoArea=new DtoArea(1,1);
        DtoPoint dtoPoint=new DtoPoint(1,1);
        dtoArea.compareTo(dtoPoint);
    }

    @Test(expected= ServiceException.class)
    public void invalidTest4() throws ServiceException{

        DtoArea1 dtoArea=new DtoArea1(null,1);
    }

    @Test(expected= NullPointerException.class)
    public void invalidTest5() throws NullPointerException{

        DtoArea1 dtoArea=new DtoArea1(1,1);
        dtoArea.compareTo(null);
    }

    @Test(expected= ClassCastException.class)
    public void invalidTest6(){

        DtoCube dtoCube1=new DtoCube(2,1,8);
        DtoArea dtoArea1=new DtoArea(2,2);
        DtoCube dtoCube2=new DtoCube(2,3,1);
        Assert.assertTrue(dtoArea1.compareTo(dtoCube1)<0);
        Assert.assertTrue(dtoCube2.compareTo(dtoArea1)<0);
    }

    @Test
    public void validTest1(){

        DtoArea dtoArea1=new DtoArea(1,2);
        DtoArea dtoArea2=new DtoArea(2,3);
        Assert.assertTrue(dtoArea2.compareTo(dtoArea1)>0);
        Assert.assertTrue(dtoArea1.compareTo(dtoArea2)<0);
    }

    @Test
    public void validTest2(){

        DtoArea dtoArea1=new DtoArea(1,2);
        DtoArea dtoArea2=new DtoArea(1,2);
        Assert.assertTrue(dtoArea2.compareTo(dtoArea1)==0);
    }

    @Test
    public void validTest3(){

        DtoArea dtoArea1=new DtoArea(1,4);
        DtoArea dtoArea2=new DtoArea(1,2);
        DtoArea dtoArea3=new DtoArea(2,6);

        ArrayList<DtoArea> lstArea=new ArrayList<>(3);
        lstArea.add(dtoArea1);
        lstArea.add(dtoArea2);
        lstArea.add(dtoArea3);

        Collections.sort(lstArea);
        Assert.assertEquals(lstArea.get(0).getArea(),Long.valueOf(2));
        Assert.assertEquals(lstArea.get(1).getArea(),Long.valueOf(4));
        Assert.assertEquals(lstArea.get(2).getArea(),Long.valueOf(12));
    }

    @Test
    public void validTest4(){

        DtoArea dtoArea1=new DtoArea(1,4);
        DtoArea dtoArea2=new DtoArea(1,2);
        DtoArea dtoArea3=new DtoArea(2,6);

        ArrayList<DtoArea> lstArea=new ArrayList<>(3);
        lstArea.add(dtoArea1);
        lstArea.add(dtoArea2);
        lstArea.add(dtoArea3);

        lstArea.sort(new Comparator<DtoArea>() {
            @Override
            public int compare(DtoArea o1, DtoArea o2) {
                return o1.compareTo(o2);
            }
        });
        Assert.assertEquals(lstArea.get(0).getArea(),Long.valueOf(2));
        Assert.assertEquals(lstArea.get(1).getArea(),Long.valueOf(4));
        Assert.assertEquals(lstArea.get(2).getArea(),Long.valueOf(12));
    }

    @Test
    public void validTest5(){

        DtoArea dtoArea1=new DtoArea(1,4);
        DtoCube dtoArea2=new DtoCube(1,2,9);
        DtoArea dtoArea3=new DtoArea(2,6);

        ArrayList<DtoArea> lstArea=new ArrayList<>(3);
        lstArea.add(dtoArea1);
        lstArea.add(dtoArea2);
        lstArea.add(dtoArea3);

        lstArea.sort(new Comparator<DtoArea>() {
            @Override
            public int compare(DtoArea o1, DtoArea o2) {
                return o1.compareTo(o2);
            }
        });
        Assert.assertEquals(lstArea.get(0).getArea(),Long.valueOf(2));
        Assert.assertEquals(lstArea.get(1).getArea(),Long.valueOf(4));
        Assert.assertEquals(lstArea.get(2).getArea(),Long.valueOf(12));
    }


    @Test
    public void validTest6(){

        DtoArea1 dtoArea1=new DtoArea1(1,2);
        DtoArea1 dtoArea2=new DtoArea1(1,2);

        HashSet<DtoArea1> lstArea=new HashSet<>();
        lstArea.add(dtoArea1);
        lstArea.add(dtoArea2);

        Assert.assertTrue(lstArea.contains(dtoArea1));
        Assert.assertTrue(lstArea.contains(dtoArea2));
    }

    @Test
    public void validTest7(){

        DtoArea1 dtoArea1=new DtoArea1(1,2);
        DtoArea1 dtoArea2=new DtoArea1(1,3);

        HashSet<DtoArea1> lstArea=new HashSet<>();
        lstArea.add(dtoArea1);
        lstArea.add(dtoArea2);

        Assert.assertTrue(lstArea.contains(dtoArea1));
        Assert.assertTrue(lstArea.contains(dtoArea2));
    }

    @Test
    public void validTest8(){

        DtoArea1 dtoArea1=new DtoArea1(1,2);
        DtoArea1 dtoArea2=new DtoArea1(1,2);

        HashMap<DtoArea1,Object> lstArea=new HashMap<>();
        lstArea.put(dtoArea1,dtoArea1);
        lstArea.put(dtoArea2,dtoArea2);

        DtoArea1 currentArea=(DtoArea1) lstArea.get(dtoArea1);
        Assert.assertTrue(lstArea.containsValue(dtoArea1));
        Assert.assertTrue(lstArea.containsValue(dtoArea2));
    }
}
