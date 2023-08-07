package com.hp.mapper;

import com.hp.pojo.Orders;
import com.hp.pojo.Users;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface OrdersMapper {
    List<Orders> getAll(Users users);


    @Update("update orders set status=#{status} where id=#{id}")
    int orderUpdate(Orders orders);

    @Delete("delete from orders where id=#{id}")
    int orderDelete(Orders orders);

    int orderInsert(Orders orders);
}
