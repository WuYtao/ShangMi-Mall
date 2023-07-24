package com.hp.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Items {
    private Integer id;
    private Integer price;
    private Integer amount;
    private Integer orderId;
    private Integer goodId;
}
