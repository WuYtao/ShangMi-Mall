package com.hp.controller.admin;

import com.hp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminUsersController {
    @Autowired
    private UsersService usersService;

    public String getAll() {
        return "admin/";
    }
}
