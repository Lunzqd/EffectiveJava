package com.rgs.effectivejava.core.interaction;

import lombok.Data;

import java.io.Serializable;

@Data
public class PagingSort implements Serializable{

    private String field;
    private String sort;
    private String sortOrder;

}