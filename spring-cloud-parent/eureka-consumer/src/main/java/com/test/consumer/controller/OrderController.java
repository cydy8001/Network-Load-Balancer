package com.test.consumer.controller;


import com.test.consumer.domain.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;



@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/goods/{id}")
    public Goods findGoodsById(@PathVariable("id") int id){
        System.out.println("findGoodsById..."+id);




        List<ServiceInstance> instances = discoveryClient.getInstances("EUREKA-PROVIDER");


        if(instances == null || instances.size() == 0){

            return null;
        }

        ServiceInstance instance = instances.get(0);
        String host = instance.getHost();
        int port = instance.getPort();

        System.out.println(host);
        System.out.println(port);

        String url = "http://"+host+":"+port+"/goods/findOne/"+id;

        Goods goods = restTemplate.getForObject(url, Goods.class);


        return goods;
    }




    @GetMapping("/goods2/{id}")
    public Goods findGoodsById2(@PathVariable("id") int id){


        String url = "http://EUREKA-PROVIDER/goods/findOne/"+id;

        Goods goods = restTemplate.getForObject(url, Goods.class);


        return goods;
    }
}
