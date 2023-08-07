package com.hp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;


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
    private LocalDateTime systime;
    private Integer userId;
    private String username;
    private List<Items> itemsList;
}
