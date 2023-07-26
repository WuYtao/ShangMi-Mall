package com.hp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hp.mapper.AdminsMapper;
import com.hp.pojo.Admins;
import com.hp.pojo.PageBean;
import com.hp.service.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.Map;

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

    /**
     * 查询所有管理员
     *
     * @return
     */
    @Override
    public PageBean getAll(Integer page) {
        if (page == null) {
            page = 1;
        }
        PageHelper.startPage(page, 5);
        List<Admins> all = adminsMapper.getAll();
        Page<Admins> p = (Page<Admins>) all;
        long YeMa = p.getTotal() / 5;
        if (p.getTotal() % 5 != 0)
            YeMa++;
        return new PageBean(p.getTotal(), p.getResult(), YeMa);
    }

    @Transactional
    @Override
    public int insert(Admins admins) {
        Admins byUsername = adminsMapper.getByUsername(admins);
        if (byUsername == null) {
            return adminsMapper.insert(admins);
        }
        return 0;
    }

    @Transactional
    @Override
    public int deleteById(Admins admins) {
        return adminsMapper.deleteById(admins);
    }

    @Transactional
    @Override
    public int adminReset(Admins admins) {
        if (admins.getPassword() == null || admins.getPassword().equals("")) {
            return 0;
        }
        String password = admins.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        admins.setPassword(password);
        return adminsMapper.adminReset(admins);
    }
}
