package com.hp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hp.mapper.GoodsMapper;
import com.hp.pojo.Goods;
import com.hp.pojo.PageBean;
import com.hp.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public PageBean getAll(Integer page, String type) {
        if (page == null) {
            page = 1;
        }
        PageHelper.startPage(page, 5);
        List<Goods> all = goodsMapper.getAll(type);
        Page<Goods> p = (Page<Goods>) all;
        long YeMa = p.getTotal() / 5;
        if (p.getTotal() % 5 != 0)
            YeMa++;
        return new PageBean(p.getTotal(), p.getResult(), YeMa);
    }

    @Override
    public Goods getById(Goods goods) {
        return goodsMapper.getById(goods);
    }

    @Override
    public int Upload(Goods goods) {
        return goodsMapper.Upload(goods);
    }

    @Override
    public int deleteById(Goods goods) {
        return goodsMapper.deleteById(goods);
    }

    @Transactional
    @Override
    public int insert(Goods goods) {
        if (
                goods.getName() == null ||
                        goods.getCover() == null ||
                        goods.getPrice() == null ||
                        goods.getIntro() == null ||
                        goods.getSpec() == null
        ) {
            return 0;
        }
        return goodsMapper.insert(goods);
    }
}
