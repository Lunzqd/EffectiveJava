package com.rgs.effectivejava.entity.section2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DtoPointColor extends DtoPoint {

    private final String color;

    public DtoPointColor(Integer x, Integer y) {

        this(x, y, "default");
    }

    public DtoPointColor(Integer x, Integer y, String color) {

        super(x, y);
        this.color=color;
    }

    /**
     * For Symmetric
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {

        if(obj==null){
            log.info("[DtoPointColor compare] obj is null");
            return false;
        }

        if(!(obj instanceof DtoPointColor)){
            log.info("[DtoPointColor compare] obj type is different");
            return false;
        }

        DtoPointColor comparePoint=(DtoPointColor)obj;
        Boolean result= super.equals(comparePoint) && comparePoint.color.equalsIgnoreCase(this.color);

        if(result){
            log.info("[DtoPointColor compare] obj is equals to this");
        }else{
            log.info("[DtoPointColor compare] obj is not equals to this");
        }
        return result;
    }


    /**
     * For transitivity
     *
     * @param obj
     * @return

    @Override
    public boolean equals(Object obj) {

        if(obj==null){
            log.info("[DtoPointColor compare] obj is null");
            return false;
        }

        if(obj instanceof DtoPointColor){
            DtoPointColor comparePoint=(DtoPointColor)obj;
            Boolean result= super.equals(comparePoint) && comparePoint.color.equalsIgnoreCase(this.color);

            if(result){
                log.info("[DtoPointColor compare] obj is equals to this");
            }else{
                log.info("[DtoPointColor compare] obj is not equals to this");
            }
            return result;

        }
        if(obj instanceof DtoPoint){
            return super.equals(obj);
        }else{
            log.info("[DtoPointColor compare] obj type is different");
            return false;
        }
    }
     */

    /**
     * Correct one
     *
     * @param obj
     * @return

    @Override
    public boolean equals(Object obj) {

        if(obj==null){
            log.info("[DtoPointColor compare] obj is null");
            return false;
        }

        if(obj.getClass()!=this.getClass()){
            log.info("[DtoPointColor compare] obj type is different");
            return false;
        }

        if(!(obj instanceof DtoPointColor)){
            log.info("[DtoPointColor compare] obj type is different");
            return false;
        }

        DtoPointColor comparePoint=(DtoPointColor)obj;
        Boolean result= super.equals(comparePoint) && comparePoint.color.equalsIgnoreCase(this.color);

        if(result){
            log.info("[DtoPointColor compare] obj is equals to this");
        }else{
            log.info("[DtoPointColor compare] obj is not equals to this");
        }
        return result;
    }
     */
}
