package com.rgs.effectivejava.Section3;

import com.rgs.effectivejava.entity.section3.InstrumentedHashSet;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@SpringBootTest
@RunWith(SpringRunner.class)
@ComponentScan("com.rgs.effectivejava")
@Slf4j
public class Item18Tests {

    @Test
    public void instrumentedHashSetTest1(){

        InstrumentedHashSet<String> instrumentedHashSet=new InstrumentedHashSet<>();
        instrumentedHashSet.addAll(Arrays.asList("Snap","Crackle","Pop"));

        Assert.assertTrue(instrumentedHashSet.getAddedCount()==3);
    }
}
