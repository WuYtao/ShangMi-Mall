package com.hp.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TopsMapper {
    @Delete("delete from tops where good_id=#{good_id}")
    int topsR(Integer good_id);
    @Insert("insert into tops(good_id) VALUES (#{good_id})")
    int topsAd(Integer good_id);
}
