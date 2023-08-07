package com.hp.service;

import com.hp.pojo.Carts;

import java.util.List;

public interface CartsService {
    int insert(Carts carts);

    int countAll(Carts carts);

    List<Carts> getByIdAll(Carts carts);

    int CartById(Carts carts);

    int cut(Carts carts);
}
