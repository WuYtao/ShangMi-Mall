package com.hp.mapper;

import com.hp.pojo.Users;
import org.apache.ibatis.annotations.*;

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

    @Delete("delete from users where id=#{id}")
    int delete(Users users);

    @Select("select * from users where id=#{id}")
    Users getById(Users users);

    @Update("update users set password=#{password} where id=#{id}")
    int userReset(Users users);

    int userUpdate(Users users);
}
