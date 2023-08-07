package com.hp.mapper;

import com.hp.pojo.CartGood;
import com.hp.pojo.Items;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemsMapper {
    int insetINto(List<CartGood> list, Integer orderId);
}
