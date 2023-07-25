package com.hp.service;

import com.hp.pojo.Types;

import java.util.List;

public interface TypesService {
    /**
     * 查询所有的类目管理
     *
     * @return
     */
    List<Types> typesAll();

    /**
     * 用户登录
     *
     * @param types
     * @return
     */
    int TypesSave(Types types);

    /**
     * 根据id删除类目
     *
     * @param types
     * @return
     */
    int deleteById(Types types);

    /**
     * 根据id来查询类目
     *
     * @return
     */
    Types getById(Types types);

    /**
     * 修改类目表
     *
     * @param types
     * @return
     */
    int update(Types types);
}
