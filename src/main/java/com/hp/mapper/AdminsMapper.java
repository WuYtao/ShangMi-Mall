package com.hp.mapper;

import com.hp.pojo.Admins;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminsMapper {
    @Select("select * from admins where username=#{username} and password=#{password}")
    Admins login(Admins admins);

    @Select("select * from admins")
    List<Admins> getAll();

    @Select("select * from admins where username=#{username}")
    Admins getByUsername(Admins admins);

    @Insert("insert into admins(username, password) VALUES (#{username},#{password})")
    int insert(Admins admins);

    @Delete("delete from admins where id=#{id}")
    int deleteById(Admins admins);

    @Update("update admins set password=#{password} where id=#{id}")
    int adminReset(Admins admins);
}
