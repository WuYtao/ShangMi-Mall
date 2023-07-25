package com.hp.service.impl;

import com.hp.mapper.AdminsMapper;
import com.hp.pojo.Admins;
import com.hp.service.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class AdminsServiceImpl implements AdminsService {
    @Autowired
    private AdminsMapper adminsMapper;

    /**
     * 后台登录接口
     *
     * @param admins
     * @return
     */
    @Override
    public Admins login(Admins admins) {
        String password = admins.getPassword();
        //md5加密
        admins.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        return adminsMapper.login(admins);
    }
}
