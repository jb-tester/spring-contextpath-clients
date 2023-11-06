package com.mytests.springcontextpathclients.feign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeighClientController {

    private final BarFeignClient barFeignClient;

    public FeighClientController(BarFeignClient barFeignClient) {
        this.barFeignClient = barFeignClient;
    }

    @GetMapping("/feignClient/bar/test3")
    public String test3(){
        return barFeignClient.test1();
    }

}
