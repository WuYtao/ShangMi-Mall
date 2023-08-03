package com.hp.controller.index;

import com.hp.pojo.Goods;
import com.hp.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("index")
public class IndexDetailController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("detail")
    public String detail(Goods id, Model model) {
        System.out.println("id = " + id);
        Goods goodsById = goodsService.getById(id);
        model.addAttribute("goodsById", goodsById);
        return "index/detail";
    }
}
