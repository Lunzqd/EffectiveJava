package com.rgs.effectivejava.entity.section2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DtoPoint {

    private final Integer x;
    private final Integer y;

    public DtoPoint(Integer x, Integer y){

        this.x=x;
        this.y=y;
    }

    /**
     * For Common test
     * 1: Exception
     * 2: Null
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {

        DtoPoint comparePoint=(DtoPoint)obj;
        Boolean result= comparePoint.x.equals(this.x) && comparePoint.y.equals(this.y);

        if(result){
            log.info("[DtoPoint compare] obj is equals to this");
        }else{
            log.info("[DtoPoint compare] obj is not equals to this");
        }
        return result;
    }



    /**
     * For Common test
     * 1: Type Cast
     * 2: Exception
     * @param obj
     * @return

    @Override
    public boolean equals(Object obj) {

        if(obj==null){
            log.info("[DtoPoint compare] obj is null");
        }
        DtoPoint comparePoint=(DtoPoint)obj;
        Boolean result= comparePoint.x.equals(this.x) && comparePoint.y.equals(this.y);

        if(result){
            log.info("[DtoPoint compare] obj is equals to this");
        }else{
            log.info("[DtoPoint compare] obj is not equals to this");
        }
        return result;
    }
     */

    /**
     * For Symmetric
     * @param obj
     * @return

    @Override
    public boolean equals(Object obj) {

        if(obj==null || !(obj instanceof DtoPoint)){
            log.info("[DtoPoint compare] obj is null or type is different");
            return false;
        }

        DtoPoint comparePoint=(DtoPoint)obj;
        Boolean result= comparePoint.x.equals(this.x) && comparePoint.y.equals(this.y);

        if(result){
            log.info("[DtoPoint compare] obj is equals to this");
        }else{
            log.info("[DtoPoint compare] obj is not equals to this");
        }
        return result;
    }
     */

    /**
     * For transitivity
     * @param obj
     * @return

    @Override
    public boolean equals(Object obj) {

        if(obj==null){
            log.info("[DtoPoint compare] obj is null or type is different");
            return false;
        }
        if(!(obj instanceof DtoPoint)){
            log.info("[DtoPoint compare] obj type is different");
            return false;
        }

        DtoPoint comparePoint=(DtoPoint)obj;
        Boolean result= comparePoint.x.equals(this.x) && comparePoint.y.equals(this.y);

        if(result){
            log.info("[DtoPoint compare] obj is equals to this");
        }else{
            log.info("[DtoPoint compare] obj is not equals to this");
        }
        return result;
    }
     */

    /**
     * Correct
     * Parent has need to consider the future equals of its inherit class
     *
     * @param obj
     * @return

    @Override
    public boolean equals(Object obj) {

        if(obj==null){
            log.info("[DtoPoint compare] obj is null or type is different");
            return false;
        }
        if(obj.getClass()!=this.getClass()){
            log.info("[DtoPoint compare] obj type is different");
            return false;
        }

        DtoPoint comparePoint=(DtoPoint)obj;
        Boolean result= comparePoint.x.equals(this.x) && comparePoint.y.equals(this.y);

        if(result){
            log.info("[DtoPoint compare] obj is equals to this");
        }else{
            log.info("[DtoPoint compare] obj is not equals to this");
        }
        return result;
    }
     */

}
