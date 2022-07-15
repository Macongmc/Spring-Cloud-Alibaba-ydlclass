package com.ydlclass.sentinelalibaba.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.RequestParam;

public class CommonBlockHandler {
    public static String HandlerBlock(@RequestParam(value = "goodsId" ,required = false) String goodsId, @RequestParam(value = "userId",required = false) String userId,
                                      BlockException exception){
        //logger.error()
        return "系统出错，请稍后再试";

    }
}
