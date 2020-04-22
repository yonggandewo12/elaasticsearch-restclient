package com.elasticsearch.restclient.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description
 * @ClassName Book
 * @Author xuliang
 * @date 2020.04.16 14:57
 */
@Data
public class Book implements Serializable {
    private String id;
    private String name;
    private String publish;
    private String type;
    private String author;
    private String info;
    private Integer price;
}
