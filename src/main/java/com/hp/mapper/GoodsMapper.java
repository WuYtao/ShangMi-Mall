package com.hp.mapper;

import com.hp.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Mapper
public interface GoodsMapper {
    List<Goods> getAll();
}
