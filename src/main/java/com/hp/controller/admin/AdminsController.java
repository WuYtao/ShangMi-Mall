package com.hp.controller.admin;

import com.hp.pojo.Admins;
import com.hp.pojo.PageBean;
import com.hp.service.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminsController {
    @Autowired
    private AdminsService adminsService;

    @GetMapping("adminList")
    public String getAll(Integer page, Model model) {
        PageBean pageBean = adminsService.getAll(page);
        int i = page == null ? 1 : page;
        model.addAttribute("page", i);
        model.addAttribute("userList", pageBean.getRows());
        model.addAttribute("userListTotal", pageBean.getTotal());
        model.addAttribute("YeMaShu", pageBean.getYeMaShu());
        model.addAttribute("next", i + 1);
        model.addAttribute("upper", i - 1);
        return "admin/admin_list";
    }

    @GetMapping("admin_add")
    public String adminAdd() {
        return "admin/admin_add";
    }

    @PostMapping("adminSave")
    public String adminSave(Admins admins, Model model) {
        int insert = adminsService.insert(admins);
        if (insert > 0) {
            model.addAttribute("adminSave", "注册成功");
            return "redirect:adminList";
        }
        model.addAttribute("adminSave", "账号已经存在注册失败");
        return "admin/admin_add";
    }

    @GetMapping("adminDelete")
    public String adminDelete(Admins admins) {
        adminsService.deleteById(admins);
        return "redirect:adminList";
    }

    @GetMapping("admin_reset")
    public String admin_reset(Admins admins, Model model) {
        model.addAttribute("admin", admins);
        return "admin/admin_reset";
    }

    @PostMapping("adminReset")
    public String adminReset(Admins admins, Model model) {
        int i = adminsService.adminReset(admins);
        if (i > 0) {
            return "redirect:adminList";
        }
        model.addAttribute("adminReset", "请输入密码");
        return "redirect:admin_reset";
    }
}
