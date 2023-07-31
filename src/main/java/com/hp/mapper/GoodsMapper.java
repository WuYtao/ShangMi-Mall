package com.hp.mapper;

import com.hp.pojo.Goods;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsMapper {
    List<Goods> getAll(String type);

    @Select("select * from goods where id=#{id}")
    Goods getById(Goods goods);

    int Upload(Goods goods);

    @Delete("delete from goods where id=#{id}")
    int deleteById(Goods goods);

    int insert(Goods goods);

    List<Goods> getByLimit();

    List<Goods> getSalesF();

    List<Goods> getSalesG();

    List<Goods> getByTypeId(Integer type_id);
}
