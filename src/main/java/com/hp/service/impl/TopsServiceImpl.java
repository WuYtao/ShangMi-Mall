package com.hp.service.impl;

import com.hp.mapper.TopsMapper;
import com.hp.service.TopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopsServiceImpl implements TopsService {
    @Autowired
    private TopsMapper topsMapper;

    @Transactional
    @Override
    public int topsR(Integer good_id) {
        return topsMapper.topsR(good_id);
    }

    @Transactional
    @Override
    public int topsAd(Integer good_id) {
        return topsMapper.topsAd(good_id);
    }
}
