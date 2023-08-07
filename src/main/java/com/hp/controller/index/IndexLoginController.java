package com.hp.controller.index;

import com.hp.pojo.Carts;
import com.hp.pojo.Users;
import com.hp.service.CartsService;
import com.hp.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    @Autowired
    private CartsService cartService;

    @GetMapping("login")
    public String login() {
        return "index/login";
    }

    @PostMapping("login")
    public String login(Users users, HttpSession session, Model model) {
        Users login = usersService.login(users);
        log.info("用户登录" + users.getName());
        if (login != null) {
            Carts carts = new Carts();
            carts.setUserId(login.getId());
            int i = cartService.countAll(carts);
            session.setAttribute("login", login);
            System.out.println("i = " + i);
            session.setAttribute("cartSize", i);
            return "redirect:index";
        }
        model.addAttribute("msg", "登录失败账号或密码错误");
        return "index/login";
    }

    @GetMapping("logout")
    public String logout(HttpSession session) {
        log.info("用户退出登录");
        session.removeAttribute("login");
        return "redirect:index";
    }

    @PostMapping("reg")
    public String register(Users users, Model model) {
        log.info("用户注册");
        int register = usersService.register(users);
        if (register == 3) {
            model.addAttribute("msg", "账号已存在");
            return "index/register";
        }
        return "index/login";
    }
}
