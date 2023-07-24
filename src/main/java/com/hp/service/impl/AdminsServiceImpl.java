package com.hp.service.impl;

import com.hp.mapper.AdminsMapper;
import com.hp.pojo.Admins;
import com.hp.service.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return adminsMapper.login(admins);
    }
}
