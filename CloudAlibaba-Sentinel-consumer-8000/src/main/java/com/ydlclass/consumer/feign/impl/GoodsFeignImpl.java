package com.ydlclass.consumer.feign.impl;

import com.ydlclass.consumer.domain.Goods;
import com.ydlclass.consumer.feign.GoodsFeign;
import org.springframework.stereotype.Component;

@Component
public class GoodsFeignImpl implements GoodsFeign {
    @Override
    public Goods find(Integer id) {
        Goods goods = new Goods();
        goods.setId(-3);
        goods.setTitle("调用方，未调到");
        return goods;
    }
}
