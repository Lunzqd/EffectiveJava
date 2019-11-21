package com.rgs.effectivejava.entity.section2;

import com.rgs.effectivejava.core.exception.ServiceException;
import lombok.AccessLevel;
import lombok.Setter;

public class DtoArea1 implements Comparable<DtoArea1> {

    private final Integer height;
    private final Integer width;

    @Setter(AccessLevel.PRIVATE)
    private Long area;

    public DtoArea1(Integer height, Integer width){

        if(height==null || width==null){
            throw new ServiceException("Fail to initialize the Area- height or width should not be null");
        }
        this.height=height;
        this.width=width;

    }

    public Long getArea(){

        return Long.valueOf(height*width);
    }

    @Override
    public int compareTo(DtoArea1 o) {

        if(o==null){
            throw new NullPointerException("The comparing object is null");
        }
        Long currentArea=o.getArea();
        Long compareArea=this.getArea();

        return Long.compare(currentArea,compareArea);
    }
}
