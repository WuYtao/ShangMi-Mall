package com.hp.controller.index;

import com.hp.pojo.Goods;
import com.hp.service.CartService;
import com.hp.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

import static com.hp.utils.ArrayListData.listData;

@Controller
@RequestMapping("index")
public class IndexIndexController {
    @Autowired
    private GoodsService goodsService;


    /**
     * 首页数据展示
     *
     * @param model
     * @return
     */
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
        ArrayList arrayList1 = listData(getByTypeId1);
        model.addAttribute("arrayList1", arrayList1);
        ArrayList arrayList2 = listData(getByTypeId2);
        model.addAttribute("arrayList2", arrayList2);
        ArrayList arrayList3 = listData(getByTypeId3);
        model.addAttribute("arrayList3", arrayList3);
        ArrayList arrayList4 = listData(getByTypeId4);
        model.addAttribute("arrayList4", arrayList4);
        ArrayList arrayList5 = listData(getByTypeId5);
        model.addAttribute("arrayList5", arrayList5);
        return "index/index";
    }
}
