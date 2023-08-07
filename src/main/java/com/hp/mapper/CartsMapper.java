package com.hp.mapper;

import com.hp.pojo.Carts;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CartsMapper {
    @Insert("insert into carts(amount, good_id, user_id) values(#{amount}, #{goodId}, #{userId}) ")
    int insert(Carts carts);

    @Select("select * from carts where user_id = #{userId} and good_id = #{goodId}")
    Carts cartBYId(Carts carts);

    @Select("select count(*) from carts where user_id = #{userId}")
    int countAll(Carts carts);

    List<Carts> getByIdAll(Carts carts);

    int CartById(Carts carts);

//    @Update("update carts set amount = #{amount} where good_id = #{goodId} and user_id = #{userId}")
    int UpdateAmount(Carts carts);
}
