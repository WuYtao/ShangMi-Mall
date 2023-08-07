package com.hp.controller.index;

import com.hp.pojo.Carts;
import com.hp.service.CartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("index")
public class IndexCartController {
    @Autowired
    private CartsService cartService;

    @GetMapping("cart")
    public String cart(Carts carts, Model model) {
        List<Carts> CartByIdAll = cartService.getByIdAll(carts);
        model.addAttribute("CartByIdAll", CartByIdAll);
        return "index/cart";
    }

    @GetMapping("cartdelete")
    public String cart(Carts carts, RedirectAttributes attributes) {
//        作用变成 cart?userId=8
        attributes.addAttribute("userId", carts.getUserId());
        int i = cartService.CartById(carts);
        return "redirect:cart";
    }
}
