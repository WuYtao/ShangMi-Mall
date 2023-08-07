package com.hp.service;

import com.hp.pojo.Orders;
import com.hp.pojo.PageBean;
import com.hp.pojo.Users;

import java.util.List;

public interface OrdersService {
    PageBean getAll(Integer page, Users users);

    int orderUpdate(Orders orders);

    int orderDelete(Orders orders);

    int orderInsert(Orders orders);
}
