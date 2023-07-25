package com.hp.service.impl;

import com.hp.mapper.TypesMapper;
import com.hp.pojo.Types;
import com.hp.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypesServiceImpl implements TypesService {
    @Autowired
    private TypesMapper typesMapper;

    @Override
    public List<Types> typesAll() {
        return typesMapper.typesAll();
    }

    @Transactional
    @Override
    public int TypesSave(Types types) {
        return typesMapper.TypesSave(types);
    }

    @Transactional
    @Override
    public int deleteById(Types types) {
        return typesMapper.deleteById(types);
    }

    @Override
    public Types getById(Types types) {
        return typesMapper.getById(types);
    }
}
