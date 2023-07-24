package com.hp.controller.index;

import com.hp.mapper.UsersMapper;
import com.hp.pojo.Users;
import com.hp.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 登录注册模块
 */
@Slf4j
@Controller
@RequestMapping("index")
public class IndexLoginController {
    @Autowired
    private UsersService usersService;

    @GetMapping("login")
    public String login() {
        return "index/login";
    }

    @PostMapping("login")
    public String login(Users users, HttpSession session, Model model) {
        Users login = usersService.login(users);
        log.info("用户登录" + users.getName());
        if (login != null) {
            session.setAttribute("login", login);
            return "index/index";
        }
        model.addAttribute("msg", "登录失败账号或密码错误");
        return "index/login";
    }

    @GetMapping("logout")
    public String logout(HttpSession session) {
        log.info("用户退出登录");
        session.removeAttribute("login");
        return "index/index";
    }

    @PostMapping("reg")
    public String register(Users users) {
        log.info("用户注册");
        int register = usersService.register(users);
        return "index/login";
    }
}
