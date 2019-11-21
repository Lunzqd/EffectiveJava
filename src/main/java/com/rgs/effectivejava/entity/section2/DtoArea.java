package com.rgs.effectivejava.entity.section2;

import com.rgs.effectivejava.core.exception.ServiceException;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class DtoArea implements Comparable{

    private final Integer height;
    private final Integer width;

    @Setter(AccessLevel.PRIVATE)
    private Long area;

    public DtoArea(Integer height, Integer width){

        if(height==null || width==null){
            throw new ServiceException("Fail to initialize the Area- height or width should not be null");
        }
        this.height=height;
        this.width=width;

    }

    public Long getArea(){

        return Long.valueOf(height*width);
    }


    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
     * <tt>y.compareTo(x)</tt> throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
     * <tt>x.compareTo(z)&gt;0</tt>.
     *
     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
     * all <tt>z</tt>.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
     * class that implements the <tt>Comparable</tt> interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Object o) {

        if(o==null){
            throw new NullPointerException("The comparing object is null");
        }
        if(!(o instanceof DtoArea)){
            throw new ClassCastException(String.format("The comparing object has different type: %s",o.getClass()));
        }

        DtoArea dtoArea=(DtoArea) o;

        Long currentArea=this.getArea();
        Long compareArea=dtoArea.getArea();

        return Long.compare(currentArea,compareArea);

    }
}
