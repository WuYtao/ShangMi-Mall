package com.hp.service.impl;

import com.hp.mapper.CartsMapper;
import com.hp.pojo.CartGood;
import com.hp.pojo.Carts;
import com.hp.service.CartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartServiceImpl implements CartsService {
    @Autowired
    private CartsMapper cartMapper;

    @Transactional
    @Override
    public int insert(Carts carts) {
        Carts carts1 = cartMapper.cartBYId(carts);
        if (carts1 == null) {
            return cartMapper.insert(carts);
        }
        int newAmount = carts1.getAmount() + 1;
        carts1.setAmount(newAmount);
        cartMapper.UpdateAmount(carts1);
        return carts1.getAmount();
    }

    @Override
    public int countAll(Carts carts) {
        return cartMapper.countAll(carts);
    }

    @Transactional
    @Override
    public List<CartGood> getByIdAll(Carts carts) {
        return cartMapper.getByIdAll(carts);
    }

    @Override
    public int CartById(Carts carts) {
        return cartMapper.CartById(carts);
    }

    @Override
    public int cut(Carts carts) {
        Carts carts1 = cartMapper.cartBYId(carts);
        if (carts1 == null) {
            return cartMapper.insert(carts);
        }
        int newAmount = carts1.getAmount() - 1;
        carts1.setAmount(newAmount);
        cartMapper.UpdateAmount(carts1);
        return carts1.getAmount();
    }
}
