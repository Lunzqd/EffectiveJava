package com.rgs.effectivejava.serviceimpl.section3;

import com.rgs.effectivejava.entity.section3.DtoLombok;
import com.rgs.effectivejava.interfaces.section3.Item16Service;
import org.springframework.stereotype.Service;

@Service
public class Item16ServiceImpl implements Item16Service {

    @Override
    public DtoLombok getLombokExample() {

        DtoLombok dtoLombok=new DtoLombok("martin，20");
        dtoLombok.setAge(20);
        dtoLombok.setName("martin");

        return dtoLombok;
    }
}
