package com.test.provider.controller;

import com.test.provider.domain.Goods;
import com.test.provider.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @Value("${server.port}")
    private int port;

    @GetMapping("/findOne/{id}")
    public Goods findOne(@PathVariable("id") int id){
        Goods goods = goodsService.findOne(id);
        goods.setTitle(goods.getTitle()+" data from port:"+port);
        return goods;
    }


}
