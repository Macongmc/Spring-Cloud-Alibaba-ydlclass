package com.ydlclass.nacosprovider8001.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Value("${server.port}")
    Integer port;
    @GetMapping("/findId/{id}")
    public String findById(@PathVariable("id") Integer id){
        return "这是port"+port+"id"+id;
    }
}
