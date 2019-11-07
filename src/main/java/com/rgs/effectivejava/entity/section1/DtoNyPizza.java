package com.rgs.effectivejava.entity.section1;

import com.rgs.effectivejava.core.exception.ServiceException;

import java.io.Serializable;

/**
 * The entity for Newyork pizza
 */
public class DtoNyPizza extends DtoPizza implements Serializable {

    private static final long serialVersionUID = 1L;

    public static class Builder extends DtoPizza.Builder<Builder>{

        public Builder(Integer size){
            super(size);
        }

        @Override
        public DtoPizza build() {

            return new DtoNyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    DtoNyPizza(Builder builder) {
        super(builder);
    }
}
