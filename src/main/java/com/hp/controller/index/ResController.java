package com.hp.controller.index;

import com.hp.pojo.Carts;
import com.hp.pojo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("index")
public class ResController {
    @PostMapping("yes")
    public Result cartInsert(@RequestBody Carts carts) {
        System.out.println("carts = " + carts);
        return Result.success(1);
    }
}
