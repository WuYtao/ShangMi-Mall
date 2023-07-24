package com.hp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    private Integer id;
    private Double total;
    private Double amount;
    private Integer status;
    private Integer paytype;
    private String name;
    private String phone;
    private String address;
    private Date systime;
    private Integer userId;
}
