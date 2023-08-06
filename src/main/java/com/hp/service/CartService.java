package com.hp.service;

import com.hp.pojo.Carts;

public interface CartService {
    int insert(Carts carts);

    int countAll(Carts carts);
}
