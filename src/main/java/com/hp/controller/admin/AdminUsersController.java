package com.hp.controller.admin;

import com.hp.pojo.PageBean;
import com.hp.pojo.Users;
import com.hp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminUsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping("userList")
    public String getAll(Integer page, Model model) {
        PageBean pageBean = usersService.getAll(page);
        int i = page == null ? 1 : page;
        model.addAttribute("page", i);
        model.addAttribute("Total", pageBean.getTotal());
        model.addAttribute("userList", pageBean.getRows());
        model.addAttribute("YeMaShu", pageBean.getYeMaShu());
        model.addAttribute("next", i + 1);
        model.addAttribute("upper", i - 1);
        return "admin/user_list";
    }

    @GetMapping("user_add")
    public String user_add() {
        return "admin/user_add";
    }

    @PostMapping("userSave")
    public String userSave(Users users) {
        int register = usersService.register(users);
        return "redirect:userList";
    }
}
