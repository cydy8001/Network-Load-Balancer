package com.test.provider.dao;

import com.test.provider.domain.Goods;
import org.springframework.stereotype.Repository;

@Repository
public class GoodsDao {
    public Goods findOne(int id){
        return new Goods(1,"iphonx",999,10000);
    }

}
