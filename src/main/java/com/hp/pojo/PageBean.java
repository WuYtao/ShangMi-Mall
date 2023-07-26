package com.hp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    private Long total;
    private List rows;
    private Long YeMaShu;

    public PageBean(Long total, List rows) {
        this.total = total;
        this.rows = rows;
    }
}
