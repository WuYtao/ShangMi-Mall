package com.hp.service;

import com.hp.pojo.Orders;
import com.hp.pojo.PageBean;

import java.util.List;

public interface OrdersService {
    PageBean getAll(Integer page);

    int orderUpdate(Orders orders);
    int orderDelete(Orders orders);
}
