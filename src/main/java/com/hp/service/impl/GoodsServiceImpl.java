package com.hp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hp.mapper.GoodsMapper;
import com.hp.pojo.Goods;
import com.hp.pojo.PageBean;
import com.hp.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public PageBean getAll(Integer page, Integer pageSize) {
        PageHelper.startPage(1, 5);
        List<Goods> all = goodsMapper.getAll();
        Page<Goods> p = (Page<Goods>) all;
        return new PageBean(p.getTotal(), p.getResult());
    }
}
