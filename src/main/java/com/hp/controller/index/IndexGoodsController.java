package com.hp.controller.index;

import com.hp.pojo.PageBean;
import com.hp.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("index")
public class IndexGoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("today")
    public String today(Model model, Integer page) {
        PageBean pageBean = goodsService.getAll(page, "1");
        int i = page == null ? 1 : page;
//        当前页面
        model.addAttribute("page", i);
//        总条数
        model.addAttribute("Total", pageBean.getTotal());
//        数据
        model.addAttribute("Rows", pageBean.getRows());
//        页码数
        model.addAttribute("YeMaShu", pageBean.getYeMaShu());
        model.addAttribute("hot", "today?page=");
//        下一页
        model.addAttribute("next", i + 1);
//        上一页
        model.addAttribute("upper", (i - 1));
        return "index/goods";
    }

    @GetMapping("hot")
    public String hot(Model model, Integer page) {
        PageBean pageBean = goodsService.getAllBySales(page);
        int i = page == null ? 1 : page;
        model.addAttribute("page", i);
        model.addAttribute("Total", pageBean.getTotal());
        model.addAttribute("Rows", pageBean.getRows());
        model.addAttribute("YeMaShu", pageBean.getYeMaShu());
        model.addAttribute("hot", "hot?page=");
        model.addAttribute("next", i + 1);
        model.addAttribute("upper", (i - 1));
        return "index/goods";
    }

    @GetMapping("type")
    public String type(Model model, Integer page, Integer id) {
        PageBean pageBean = goodsService.getByTypeId(page, id);
        int i = page == null ? 1 : page;
        model.addAttribute("page", i);
        model.addAttribute("Total", pageBean.getTotal());
        model.addAttribute("Rows", pageBean.getRows());
        model.addAttribute("YeMaShu", pageBean.getYeMaShu());
        model.addAttribute("hot", "type?id=" + id + "&page=");
        model.addAttribute("next", i + 1);
        model.addAttribute("upper", (i - 1));
        return "index/goods";
    }

    @GetMapping("new")
    public String news(Model model, Integer page, Integer id) {
        PageBean pageBean = goodsService.getByIdAllASCId(page);
        int i = page == null ? 1 : page;
        model.addAttribute("page", i);
        model.addAttribute("Total", pageBean.getTotal());
        model.addAttribute("Rows", pageBean.getRows());
        model.addAttribute("YeMaShu", pageBean.getYeMaShu());
        model.addAttribute("hot", "new?page=");
        model.addAttribute("next", i + 1);
        model.addAttribute("upper", (i - 1));
        return "index/goods";
    }

    /**
     * 搜索商品
     *
     * @param model
     * @param page
     * @param name
     * @return
     */
    @PostMapping("search")
    public String search(Model model, Integer page, String name) {
        PageBean pageBean = goodsService.getByLike(page, name);
        int i = page == null ? 1 : page;
        model.addAttribute("page", i);
        model.addAttribute("Total", pageBean.getTotal());
        model.addAttribute("Rows", pageBean.getRows());
        model.addAttribute("YeMaShu", pageBean.getYeMaShu());
        model.addAttribute("hot", "search?page=");
        model.addAttribute("next", i + 1);
        model.addAttribute("upper", (i - 1));
        return "index/goods";
    }
}
