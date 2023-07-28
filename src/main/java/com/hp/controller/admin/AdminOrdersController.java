package com.hp.controller.admin;

import com.hp.pojo.Orders;
import com.hp.pojo.PageBean;
import com.hp.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminOrdersController {
    @Autowired
    private OrdersService ordersService;

    @GetMapping("orderList")
    public String orderList(Integer page, Model model) {
        PageBean pageBean = ordersService.getAll(page);
        int i = page == null ? 1 : page;
        model.addAttribute("page", i);
        model.addAttribute("Total", pageBean.getTotal());
        model.addAttribute("Orders", pageBean.getRows());
        model.addAttribute("YeMaShu", pageBean.getYeMaShu());
        model.addAttribute("next", i + 1);
        model.addAttribute("upper", i - 1);
        return "admin/order_list";
    }

    @GetMapping("orderUpdate")
    public String orderUpdate(Orders orders) {
        int i = ordersService.orderUpdate(orders);
        return "redirect:orderList";
    }

    @GetMapping("orderDelete")
    public String orderDelete(Orders orders) {
        int i = ordersService.orderDelete(orders);
        return "redirect:orderList";
    }
}
