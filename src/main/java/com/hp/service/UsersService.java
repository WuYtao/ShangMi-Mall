package com.hp.service;

import com.hp.pojo.Users;

public interface UsersService {
    Users login(Users users);

    int register(Users users);
}
