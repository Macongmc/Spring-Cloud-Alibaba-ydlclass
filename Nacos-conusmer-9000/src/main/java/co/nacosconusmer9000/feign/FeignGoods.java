package co.nacosconusmer9000.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("nacos-provider")
public interface FeignGoods {
    @GetMapping("/goods/findId/{id}")
    public String findById(@PathVariable("id") Integer id);
}
