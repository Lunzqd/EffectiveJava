package com.rgs.effectivejava.entity.section3;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.HashSet;

/**
 * 重写一个HashSet，计算从创立对象到现在为止，有多少元素被添加过
 * addedCount！=set.size()
 * @param <E>
 */
@Data
public class InstrumentedHashSet<E> extends HashSet<E> {

    @Setter(AccessLevel.PRIVATE)
    private Integer addedCount=0;

    public InstrumentedHashSet(){super();}

    public InstrumentedHashSet(int initCap, float loadFactor){

        super(initCap,loadFactor);
    }

    @Override
    public boolean add(E e) {

        this.addedCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        this.addedCount+=c.size();
        return super.addAll(c);
    }

}
