package com.hp.controller.index;

import com.hp.pojo.PageBean;
import com.hp.pojo.Users;
import com.hp.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("index")
public class IndexOrderController {
    @Autowired
    private OrdersService ordersService;

    @GetMapping("order")
    public String index(Integer page, Users users, Model model) {
        System.out.println("users = " + users);
        PageBean pageBean = ordersService.getAll(page, users);
        model.addAttribute("Orders", pageBean.getRows());
        return "index/order";
    }

}
