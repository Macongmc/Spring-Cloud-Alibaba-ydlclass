package com.ydlclass.consumer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ydlclass.consumer.domain.Goods;
import com.ydlclass.consumer.feign.GoodsFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    GoodsFeign goodsFeign;
    @GetMapping("/add/{id}")
//    @SentinelResource(value = "add",blockHandler = "fail_add")
    @SentinelResource(value = "add",fallback = "fallback",blockHandler = "fail_add",exceptionsToIgnore = {IllegalArgumentException.class})
    public Goods addOrder(@PathVariable("id") Integer id){
        String url ="http://sentinel-provider/goods/findById/"+id;
        Goods forObject = restTemplate.getForObject(url, Goods.class);
        if (id<0){
            throw  new IllegalArgumentException("非法参数");
        }else if (id >100){
            throw new NullPointerException("查无此商品");
        }
        return forObject;
    }
    @GetMapping("/add1/{id}")
//    @SentinelResource(value = "add",blockHandler = "fail_add")
    @SentinelResource(value = "add",fallback = "fallback",blockHandler = "fail_add",exceptionsToIgnore = {IllegalArgumentException.class})
    public Goods add(@PathVariable("id") Integer id){
        Goods goods = goodsFeign.find(id);
        return goods;
    }
    public Goods fail_add(@PathVariable("id") Integer id, BlockException blockException){
       Goods forObject = new Goods();
       forObject.setId(-1);
       forObject.setTitle("错误");
        return forObject;
    }
    public Goods fallback(@PathVariable("id") Integer id,Throwable throwable){
       Goods goods = new Goods();
       goods.setId(-2);
       goods.setTitle("业务出错");
       return goods;
    }
}
