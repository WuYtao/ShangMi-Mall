package com.hp.mapper;

import com.hp.pojo.Carts;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CartMapper {
    @Insert("insert into carts(amount, good_id, user_id) values(#{amount}, #{goodId}, #{userId}) ")
    int insert(Carts carts);

    @Select("select count(*) from carts where user_id = #{userId}")
    int countAll(Carts carts);
}
