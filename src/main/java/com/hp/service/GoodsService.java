package com.hp.service;

import com.hp.pojo.Goods;
import com.hp.pojo.PageBean;

import java.util.List;

public interface GoodsService {
    PageBean getAll(Integer page, Integer pageSize);
}
