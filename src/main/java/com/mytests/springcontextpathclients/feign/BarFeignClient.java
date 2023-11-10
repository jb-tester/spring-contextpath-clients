package com.mytests.springcontextpathclients.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "test1", url = "http://localhost:8081/spring/tests")
public interface BarFeignClient {

    // generated HTTP Request is incorrect:
    // GET http://localhost:8081/spring/tests/spring/tests/bar/test3
    // expected:
    // GET http://localhost:8081/spring/tests/bar/test3
    @GetMapping("/bar/test3")
    String test1();

    @GetMapping("/bar/test4")
    String test2();
}
