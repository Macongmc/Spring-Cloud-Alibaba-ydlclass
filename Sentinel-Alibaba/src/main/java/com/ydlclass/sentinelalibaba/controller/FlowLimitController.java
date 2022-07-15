package com.ydlclass.sentinelalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ydlclass.sentinelalibaba.handler.CommonBlockHandler;
import com.ydlclass.sentinelalibaba.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flow")
public class FlowLimitController {
    @Autowired
    GoodsService service;
    @GetMapping("/testA")
    public String testA(){
        return "it testA";
    }
    @GetMapping("/testB")
    public String testB(){
        service.find();
        return "it testB";
    }
    @GetMapping("/testC/{id}")
    public String testC(@PathVariable("id") Integer id){
        if (id ==10 ){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }return "textC";
    }
    @GetMapping("/testD/{id}")
    public String testD(@PathVariable("id") Integer id){
        if (id ==10 ){
        int i =1/0;
        }return "textC";
    }
    @GetMapping("/order")
    @SentinelResource(value = "hotKey",blockHandler = "blockOrder")
    public String order(@RequestParam(value = "goodsId" ,required = false) String goodsId,@RequestParam(value = "userId",required = false) String userId){
     //业务逻辑
        return "用户下单成功";
    }
    public String blockOrder(@RequestParam(value = "goodsId" ,required = false) String goodsId,
                             @RequestParam(value = "userId",required = false) String userId,
                             BlockException exception){
        //业务逻辑
        return "用户下单失败，请稍后重试";
    }
    @GetMapping("/query")
    @SentinelResource(value = "hotKey",blockHandlerClass = CommonBlockHandler.class,blockHandler = "HandlerBlock")
    public String query(@RequestParam(value = "goodsId" ,required = false) String goodsId,@RequestParam(value = "userId",required = false) String userId){
        //业务逻辑
        return "用户查询成功";
    }
}
