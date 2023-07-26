package com.hp.service;

import com.hp.pojo.Users;

import java.util.List;

public interface UsersService {
    Users login(Users users);

    int register(Users users);

    List<Users> getAll();

}
