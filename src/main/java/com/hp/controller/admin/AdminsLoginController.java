package com.hp.controller.admin;

import com.hp.pojo.Admins;
import com.hp.service.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminsLoginController {
    @Autowired
    private AdminsService adminsService;

    @GetMapping("login")
    public String index(Admins admins, Model model) {
        return "admin/login";
    }

    @PostMapping("login")
    public String login(Admins admins, Model model) {
        Admins login = adminsService.login(admins);
        if (login != null) {
            model.addAttribute("alogin", login);
            return "redirect:/admin/typeList";
        }
        model.addAttribute("adminLogin", "账号或密码错误，请重新输入！");
        return "admin/login";
    }
}
