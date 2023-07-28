package com.hp.controller.admin;

import com.hp.service.TopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminTopsController {
    @Autowired
    private TopsService topsService;

    @GetMapping("topsr")
    public String topsR(Integer good_id) {
        int i = topsService.topsR(good_id);
        return "redirect:goodList";
    }

    @GetMapping("topsad")
    public String topsAd(Integer good_id) {
        int i = topsService.topsAd(good_id);
        return "redirect:goodList";
    }
}
