package com.hp.controller.admin;

import com.hp.pojo.PageBean;
import com.hp.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("admin")
public class AdminGoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("goodList")
    public String index(Integer page, Integer pageSize, Model model) {
        PageBean pageBean = goodsService.getAll(page, pageSize);
        model.addAttribute("Total", pageBean.getTotal());
        model.addAttribute("Rows", pageBean.getRows());

        return "admin/good_list";
    }
}
