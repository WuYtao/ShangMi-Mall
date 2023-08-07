package com.hp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hp.mapper.UsersMapper;
import com.hp.pojo.Goods;
import com.hp.pojo.PageBean;
import com.hp.pojo.Users;
import com.hp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Users login(Users users) {
        String password = users.getPassword();
        //md5加密
        users.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
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
        if (users.getName() == null || users.getUsername() == null || users.getPassword() == null) {
            return 3;
        }
        String password = users.getPassword();
        //md5加密
        users.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        Users users1 = usersMapper.getByUsername(users);
//        查出来由数据表示已经存在
        if (users1 != null) {
            return 3;
        }
        return usersMapper.insert(users);
    }

    /**
     * 返回全部员工信息
     *
     * @return
     */
    @Override
    public PageBean getAll(Integer page) {
        if (page == null) {
            page = 1;
        }
        PageHelper.startPage(page, 5);
        List<Users> all = usersMapper.getAll();
        Page<Users> p = (Page<Users>) all;
        long YeMa = p.getTotal() / 5;
        if (p.getTotal() % 5 != 0)
            YeMa++;
        return new PageBean(p.getTotal(), p.getResult(), YeMa);
    }

    @Transactional
    @Override
    public int delete(Users users) {
        return usersMapper.delete(users);
    }

    @Override
    public Users getById(Users users) {
        return usersMapper.getById(users);
    }

    @Transactional
    @Override
    public int userReset(Users users) {
        if (users.getPassword() == null) {
            return 0;
        }
        return usersMapper.userReset(users);
    }

    @Transactional
    @Override
    public int userUpdate(Users users) {
        return usersMapper.userUpdate(users);
    }

    @Transactional
    @Override
    public int UploadAddress(Users users) {
        return usersMapper.UploadAddress(users);
    }
}
