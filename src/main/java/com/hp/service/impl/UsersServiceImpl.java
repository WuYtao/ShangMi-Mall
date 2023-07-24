package com.hp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hp.mapper.UsersMapper;
import com.hp.pojo.Users;
import com.hp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Users login(Users users) {
        return usersMapper.login(users);
    }

    /**
     * 账号注册
     *
     * @return 3代表账号存在，不注册
     */
    @Transactional
    @Override
    public int register(Users users) {
        LambdaQueryWrapper<Users> lqw = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<Users> eq = lqw.eq(Users::getUsername, users.getUsername());
        Users users1 = usersMapper.selectOne(eq);
//        查出来由数据表示已经存在
        if (users1 != null) {
            return 3;
        }
        return usersMapper.insert(users);
    }
}
