package com.hp.service;

import com.hp.pojo.PageBean;
import com.hp.pojo.Users;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UsersService {
    Users login(Users users);

    int register(Users users);

    PageBean getAll(Integer page);

    int delete(Users users);

    Users getById(Users users);

    int userReset(Users users);

    int userUpdate(Users users);
}
