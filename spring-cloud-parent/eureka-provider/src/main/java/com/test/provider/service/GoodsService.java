package com.test.provider.service;

import com.test.provider.dao.GoodsDao;
import com.test.provider.domain.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    public Goods findOne(int id){
        return goodsDao.findOne(id);
    }
}
