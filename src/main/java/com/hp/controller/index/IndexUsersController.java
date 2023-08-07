package com.hp.controller.index;

import com.hp.pojo.Users;
import com.hp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("index")
public class IndexUsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping("address")
    public String address(Users users, Model model) {
        Users userById = usersService.getById(users);
        model.addAttribute("userById", userById);
        return "index/address";
    }

    @PostMapping("addressUpdate")
    public String addressUpdate(Users users) {
        int i = usersService.userUpdate(users);
        return "redirect:index";
    }

    @GetMapping("password")
    public String UploadPassword(Users users, Model model) {
        Users userById = usersService.getById(users);
        model.addAttribute("userById", userById);
        return "index/password";
    }

    @PostMapping("passwordUpdate")
    public String passwordUpdate(Integer id, String newPassword) {
        newPassword = DigestUtils.md5DigestAsHex(newPassword.getBytes());
        Users users = new Users();
        users.setId(id);
        users.setPassword(newPassword);
        int i = usersService.userReset(users);
        return "redirect:index";
    }
}
