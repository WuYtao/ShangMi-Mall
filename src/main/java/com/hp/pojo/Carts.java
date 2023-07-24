package com.hp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Carts {
    private  Integer id;
    private Integer amount;
    private Integer goodId;
    private Integer userId;
}
