package com.hp.mapper;

import com.hp.pojo.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UsersMapper {
    Users login(Users users);

    @Select("select * from users where username = #{username}")
    Users getByUsername(Users users);

    @Insert("insert into users(username, password, name, phone, address) values" +
            " (#{username},#{password},#{name},#{phone},#{address})")
    int insert(Users users);
    @Select("select * from users")
    List<Users> getAll();
}
