package com.rgs.effectivejava.entity.section2;

import com.rgs.effectivejava.core.exception.ServiceException;

public class DtoCube extends DtoArea {

    private final Integer deep;

    public DtoCube(Integer height, Integer width, Integer deep) {

        super(height, width);

        if(deep==null){
            throw new ServiceException("Fail to initialize the Area- deep should not be null");
        }
        this.deep=deep;
    }

    public Long getCube(){

        return Long.valueOf(super.getArea()*this.deep);
    }

    @Override
    public int compareTo(Object o) {

        if(o==null){
            throw new NullPointerException("The comparing object is null");
        }
        //Do not allow to make transitivity comparision
        //This class do not allow to compare with this parent class
        if(!(o instanceof DtoCube)){
            if(!(o instanceof DtoArea)){
                throw new ClassCastException(String.format("The comparing object has different type: %s",o.getClass()));
            }else{
                return super.compareTo(o);
            }
        }

        DtoCube dtoCube=(DtoCube) o;

        Long currentCube=this.getCube();
        Long compareCube=dtoCube.getCube();

        return Long.compare(currentCube,compareCube);
    }
}
