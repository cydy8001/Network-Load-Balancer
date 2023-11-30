package com.test.provider.dao;

import com.test.provider.domain.Goods;
import org.springframework.stereotype.Repository;

import javax.validation.ReportAsSingleViolation;



@Repository
public class GoodsDao {
    public Goods findOne(int id){
        return new Goods(1,"Iphone13pro",3999,10000);
    }
}
