package co.nacosconusmer9000.controller;

import co.nacosconusmer9000.feign.FeignGoods;
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
    FeignGoods feignGoods;
    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") Integer id){
        String url = "http://nacos-provider/goods//findId/"+id;
        String forObject = restTemplate.getForObject(url, String.class);
        return forObject;

    }
    @GetMapping("/add2/{id}")
    public String add2(@PathVariable("id") Integer id){
        return feignGoods.findById(id);

    }
    @GetMapping("/text")
    public String ok(){
        return "ok";
    }
}
