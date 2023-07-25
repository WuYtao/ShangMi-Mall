package com.hp.controller.admin;

import com.hp.pojo.Types;
import com.hp.service.AdminsService;
import com.hp.service.TypesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private TypesService typesService;

    @GetMapping("typeList")
    public String allTypes(Model model) {
        log.info("查询所有的类目");
        List<Types> types = typesService.typesAll();
        model.addAttribute("types", types);
        return "admin/index";
    }

    @GetMapping("type_add")
    public String typeAddIndex() {
        return "admin/type_add";
    }

    @PostMapping("typeSave")
    public String typeSave(Types types) {
        log.info("添加类目" + types.getName());
        int i = typesService.TypesSave(types);
        return "redirect:/typeList";
    }

    @GetMapping("typeDelete")
    public String deleteById(Types types) {
        log.info("删除id为" + types.getId() + "的类目");
        int i = typesService.deleteById(types);
        return "redirect:typeList";
    }

    @GetMapping("typeEdit")
    public String getById(Types types, Model model) {
        Types typesId = typesService.getById(types);
        model.addAttribute("typesId", typesId);
        return "admin/type_edit";
    }
}
