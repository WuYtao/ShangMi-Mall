package com.hp.controller.index;

import com.hp.pojo.Carts;
import com.hp.pojo.Result;
import com.hp.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("index")
public class ResController {
    @Autowired
    private CartService cartService;

    @PostMapping("yes")
    public Result cartInsert(@RequestBody Carts carts) {
        int insert = cartService.insert(carts);
        int countAll = cartService.countAll(carts);
        Map<Object, Object> map = new HashMap<>();
        map.put("inset", insert);
        map.put("countAll", countAll);
        return Result.success(map);
    }

    @GetMapping("CartSize")
    public Result CartSize(Carts carts) {
        int countAll = cartService.countAll(carts);
        return Result.success(countAll);
    }
}
