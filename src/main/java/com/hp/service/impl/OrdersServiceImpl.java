package com.hp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hp.mapper.OrdersMapper;
import com.hp.pojo.Orders;
import com.hp.pojo.PageBean;
import com.hp.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public PageBean getAll(Integer page) {
        if (page == null) {
            page = 1;
        }
        PageHelper.startPage(page, 5);
        List<Orders> all = ordersMapper.getAll();
        Page<Orders> p = (Page<Orders>) all;
        long YeMa = p.getTotal() / 5;
        if (p.getTotal() % 5 != 0)
            YeMa++;
        return new PageBean(p.getTotal(), p.getResult(), YeMa);
    }

    @Transactional
    @Override
    public int orderUpdate(Orders orders) {
        return ordersMapper.orderUpdate(orders);
    }

    @Transactional
    @Override
    public int orderDelete(Orders orders) {
        return ordersMapper.orderDelete(orders);
    }
}
