package com.rgs.effectivejava.entity.section1;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.io.Serializable;

@Data
@Setter(AccessLevel.PRIVATE)
public class DtoCalzone extends DtoPizza implements Serializable {

    private static final long serialVersionUID = 1L;
    private Boolean sourceInside;

    public static class Builder extends DtoPizza.Builder<Builder>{

        private Boolean sourceInside=false;

        public Builder(Integer size){
            super(size);
        }

        public Builder sourceInside(Boolean sourceInside){

            this.sourceInside=sourceInside;
            return self();
        }

        @Override
        public DtoCalzone build() {

            return new DtoCalzone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    DtoCalzone(Builder builder) {
        super(builder);
        this.sourceInside=builder.sourceInside;
        if(this.sourceInside==null){
            this.sourceInside=true;
        }
    }
}
