package com.hp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hp.pojo.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapper extends BaseMapper<Users> {
    Users login(Users users);
}
