package com.hp.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("index")
public class IndexCartController {
    @GetMapping("cart")
    public String cart() {
        return "index/cart";
    }
}
