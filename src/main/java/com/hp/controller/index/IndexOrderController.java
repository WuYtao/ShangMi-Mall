package com.hp.controller.index;

import com.hp.pojo.*;
import com.hp.service.CartsService;
import com.hp.service.OrdersService;
import com.hp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("index")
public class IndexOrderController {
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private CartsService cartsService;

    @GetMapping("order")
    public String index(Integer page, Users users, Model model) {
        PageBean pageBean = ordersService.getAll(page, users);
        model.addAttribute("Orders", pageBean.getRows());
        return "index/order";
    }

    @GetMapping("orderSave")
    public String getOrdersService(Users users, Model model, Carts carts) {
        carts.setUserId(users.getId());
        Users userById = usersService.getById(users);
        List<CartGood> CartByIdAll = cartsService.getByIdAll(carts);
        int c = 0;
        for (CartGood cartGood : CartByIdAll) {
            c += (cartGood.getGoods().getPrice() * cartGood.getCarts().getAmount());
        }
        model.addAttribute("zj", c);
        model.addAttribute("userById", userById);
        model.addAttribute("CartByIdAll", CartByIdAll);
        return "index/pay";
    }

    @PostMapping("orderPay")
    public String orderPay(Orders orders) {
        int i = ordersService.orderInsert(orders);
        return "index/payok";
    }
}
