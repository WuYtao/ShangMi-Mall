package com.hp.service;

import com.hp.pojo.Admins;
import com.hp.pojo.PageBean;

import java.util.List;

public interface AdminsService {
    Admins login(Admins admins);

    PageBean getAll(Integer page);

    int insert(Admins admins);

    int deleteById(Admins admins);

    int adminReset(Admins admins);
}
