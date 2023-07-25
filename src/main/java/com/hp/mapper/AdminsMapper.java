package com.hp.mapper;

import com.hp.pojo.Admins;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminsMapper {
    @Select("select * from admins where username=#{username} and password=#{password}")
    Admins login(Admins admins);

}
