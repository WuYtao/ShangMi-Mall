package com.hp.service.impl;

import com.hp.mapper.CartMapper;
import com.hp.pojo.Carts;
import com.hp.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;

    @Transactional
    @Override
    public int insert(Carts carts) {
        return cartMapper.insert(carts);
    }

    @Override
    public int countAll(Carts carts) {
        return cartMapper.countAll(carts);
    }
}
