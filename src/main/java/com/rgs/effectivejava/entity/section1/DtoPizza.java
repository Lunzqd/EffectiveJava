package com.rgs.effectivejava.entity.section1;

import com.rgs.effectivejava.core.exception.ServiceException;
import com.rgs.effectivejava.core.util.StringUtil;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * The parent pizza which specified the generic properties and behaviors
 */
@Data
@Setter(AccessLevel.PRIVATE)
public abstract class DtoPizza implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer size;
    private Set<String> toppings;

    @Data
    abstract static class Builder<T extends Builder<T>>{

        private Integer size;
        private Set<String> toppings;

        public Builder(Integer size){

            if(size==null || size<=0){
                throw new ServiceException("Please specify the size of your pizza");
            }
            this.size=size;
            this.toppings=new HashSet<>();
        }

        public T addTopping(String topping){

            if(!StringUtil.isEmpty(topping)){

                if(!this.toppings.contains(topping)){

                    this.toppings.add(topping);
                }
            }
            return self();
        }

        abstract DtoPizza build();

        protected abstract T self();
    }

    DtoPizza(Builder<?> builder){

        this.size=builder.size;
        this.toppings=builder.toppings;
    }
}
