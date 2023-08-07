package com.hp.service;

import com.hp.pojo.CartGood;
import com.hp.pojo.Carts;

import java.util.List;

public interface CartsService {
    int insert(Carts carts);

    int countAll(Carts carts);

    List<CartGood> getByIdAll(Carts carts);

    int CartById(Carts carts);

    int cut(Carts carts);
}
