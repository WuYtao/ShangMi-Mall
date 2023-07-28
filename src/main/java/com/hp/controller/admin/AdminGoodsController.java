package com.hp.controller.admin;

import com.hp.pojo.Goods;
import com.hp.pojo.PageBean;
import com.hp.pojo.Types;
import com.hp.service.GoodsService;
import com.hp.service.TypesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Slf4j
@Controller
@RequestMapping("admin")
public class AdminGoodsController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private TypesService typesService;

    @GetMapping("goodList")
    public String index(String type, Integer page, Model model) {
        PageBean pageBean = goodsService.getAll(page, type);
        int i = page == null ? 1 : page;
        model.addAttribute("page", i);
        model.addAttribute("Total", pageBean.getTotal());
        model.addAttribute("Rows", pageBean.getRows());
        model.addAttribute("YeMaShu", pageBean.getYeMaShu());
        if (type != null) {
            model.addAttribute("ok", "ok");
            model.addAttribute("next", i + 1 + "&type=1");
            model.addAttribute("upper", i - 1 + "&type=1");
        } else {
            model.addAttribute("next", i + 1);
            model.addAttribute("upper", i - 1);
        }
        return "admin/good_list";
    }

    @GetMapping("goodEdit")
    public String goodEdit(Goods goods, Model model) {
        Goods byId = goodsService.getById(goods);
        List<Types> types = typesService.typesAll();
        model.addAttribute("goodsById", byId);
        model.addAttribute("typeList", types);
        return "admin/good_edit";
    }

    @GetMapping("goodDelete")
    public String goodDelete(Goods goods) {
        int i = goodsService.deleteById(goods);
        return "redirect:goodList";
    }

    @GetMapping("goodAdd")
    public String goodAdd(Model model) {
        List<Types> types = typesService.typesAll();
        model.addAttribute("typeList", types);
        return "admin/good_add";
    }

    @PostMapping("goodSave")
    public String goodSave(Goods goods, MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
//        构造唯一的文件（不能重复）-uuid(通用唯一识别码)长度固定的字符串
        int index = originalFilename.lastIndexOf(".");
        String extname = originalFilename.substring(index);
        String newFileName = UUID.randomUUID().toString() + extname;
        log.info("新的文件名:{}", newFileName);
        goods.setCover("../upload/" + newFileName);
//        将文件存储在服务器的磁盘目录中
        file.transferTo(new File("E:\\MyDesktop\\ShangmiMall\\XM\\Sm_Mall\\static\\upload\\" + newFileName));
        int insert = goodsService.insert(goods);
        return "redirect:goodList";
    }
}
