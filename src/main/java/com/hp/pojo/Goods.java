package com.hp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private Integer id;
    private String cover;
    private String name;
    private String intro;
    private  String spec;
    private Integer price;
    private Integer stock;
    private Integer sales;
    private String content;
    private Integer typeId;
}
