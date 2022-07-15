package com.ydlclass.provider.controller;

import com.ydlclass.provider.domain.Goods;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Value("${server.port}")
    String port;
    @GetMapping("/findById/{id}")
    public Goods find(@PathVariable("id") Integer id){
        Goods goods = new Goods();
        goods.setId(1);
        goods.setTitle("9001");
        goods.setStock(10);
        System.out.println(port);
        return goods;
    }
}
