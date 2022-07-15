package com.ydlclass.consumer.feign;

import com.ydlclass.consumer.domain.Goods;
import com.ydlclass.consumer.feign.impl.GoodsFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(value = "sentinel-provider",fallback = GoodsFeignImpl.class)
public interface GoodsFeign {
    @GetMapping("/goods/findById/{id}")
    public Goods find(@PathVariable("id") Integer id);
}
