package com.hp.controller.admin;

import com.hp.pojo.Goods;
import com.hp.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.UUID;

@Slf4j
@Controller
@RequestMapping("admin")
public class UploadController {
    @Autowired
    private GoodsService goodsService;

    //    文件上传使用MulticastChannel 接收
    @PostMapping("goodUpdate")
    public String upload(Goods goods, MultipartFile file) throws IOException {
//        获取原始的文件名
        String originalFilename = file.getOriginalFilename();
//        构造唯一的文件（不能重复）-uuid(通用唯一识别码)长度固定的字符串
        int index = originalFilename.lastIndexOf(".");
        String extname = originalFilename.substring(index);
        String newFileName = UUID.randomUUID().toString() + extname;
        log.info("新的文件名:{}", newFileName);
        goods.setCover("../upload/" + newFileName);
//        将文件存储在服务器的磁盘目录中
        file.transferTo(new File("E:\\MyDesktop\\ShangmiMall\\XM\\Sm_Mall\\static\\upload\\" + newFileName));
        int upload = goodsService.Upload(goods);
        return "redirect:goodList";
    }
}
