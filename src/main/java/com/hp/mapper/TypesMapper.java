package com.hp.mapper;

import com.hp.pojo.Types;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TypesMapper {
    @Select("select * from types order by num asc")
    List<Types> typesAll();

    @Insert("insert into types(name, num) VALUES (#{name},#{num})")
    int TypesSave(Types types);

    @Delete("delete from types where id=#{id}")
    int deleteById(Types types);

    @Select("select  * from types where id=#{id}")
    Types getById(Types types);
}
