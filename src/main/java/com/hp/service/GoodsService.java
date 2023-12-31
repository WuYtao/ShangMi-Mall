package com.hp.service;

import com.hp.pojo.Goods;
import com.hp.pojo.PageBean;
import org.springframework.ui.Model;

import java.util.List;

public interface GoodsService {
    PageBean getAll(Integer page, String type);

    Goods getById(Goods goods);

    int Upload(Goods goods);

    int deleteById(Goods goods);

    int insert(Goods goods);

    List<Goods> getByLimit();

    List<Goods> getSalesF();

    List<Goods> getSalesG();

    List<Goods> getByTypeId(Integer type_id);

    PageBean getAllBySales(Integer page);

    PageBean getByTypeId(Integer page, Integer id);

    PageBean getByIdAllASCId(Integer page);
    PageBean getByLike(Integer page,String name);
}
