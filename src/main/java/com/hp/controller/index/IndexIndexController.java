package com.hp.controller.index;

import com.hp.pojo.Goods;
import com.hp.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("index")
public class IndexIndexController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("index")
    public String index(Model model) {
        List<Goods> goodsTops = goodsService.getByLimit();
        List<Goods> goodsHotQ = goodsService.getSalesF();
        List<Goods> goodsHotG = goodsService.getSalesG();
        List<Goods> getByTypeId1 = goodsService.getByTypeId(1);
        List<Goods> getByTypeId2 = goodsService.getByTypeId(2);
        List<Goods> getByTypeId3 = goodsService.getByTypeId(3);
        List<Goods> getByTypeId4 = goodsService.getByTypeId(4);
        List<Goods> getByTypeId5 = goodsService.getByTypeId(5);
        model.addAttribute("goodsTops", goodsTops);
        model.addAttribute("goodsHotQ", goodsHotQ);
        model.addAttribute("goodsHotG", goodsHotG);
        model.addAttribute("getByTypeId1", getByTypeId1);
        long getId1 = getByTypeId1.size() / 5;
        getId1 = getByTypeId1.size() % 5 != 0 ? getId1 + 1 : getId1;
        model.addAttribute("getId1", getId1);
        model.addAttribute("getByTypeId2", getByTypeId2);
        model.addAttribute("getByTypeId3", getByTypeId3);
        model.addAttribute("getByTypeId4", getByTypeId4);
        model.addAttribute("getByTypeId5", getByTypeId5);
        return "index/index";
    }
}
