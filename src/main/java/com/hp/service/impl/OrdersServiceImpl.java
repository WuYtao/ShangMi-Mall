package com.hp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hp.mapper.CartsMapper;
import com.hp.mapper.ItemsMapper;
import com.hp.mapper.OrdersMapper;
import com.hp.pojo.*;
import com.hp.service.CartsService;
import com.hp.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private CartsMapper cartsMapper;

    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public PageBean getAll(Integer page, Users users) {
        if (page == null) {
            page = 1;
        }
        PageHelper.startPage(page, 5);
        List<Orders> all = ordersMapper.getAll(users);
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

    @Transactional
    @Override
    public int orderInsert(Orders orders) {
        Carts carts = new Carts();
        carts.setUserId(orders.getUserId());
        List<CartGood> cartByIdAll = cartsMapper.getByIdAll(carts);
        Double total = 0.00;
        Double amount = 0.00;
        for (CartGood cartGood : cartByIdAll) {
            total += (cartGood.getCarts().getAmount() * cartGood.getGoods().getPrice());
            amount += (cartGood.getCarts().getAmount());
        }
        orders.setTotal(total);
        orders.setAmount(amount);
        orders.setSystime(LocalDateTime.now());
        ordersMapper.orderInsert(orders);
        Integer orderId = orders.getId();
        int i = itemsMapper.insetINto(cartByIdAll, orderId);
        if (i > 0) {
            cartsMapper.CartDeleteAll(orders.getUserId());
        }
        return 6;
    }
}
