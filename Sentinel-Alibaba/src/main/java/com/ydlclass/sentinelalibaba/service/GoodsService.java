package com.ydlclass.sentinelalibaba.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Component;

@Component
public class GoodsService {
    @SentinelResource("queryGood")
    public void find(){
        System.out.println("查询商品");

    }
}
