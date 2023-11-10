package com.mytests.springcontextpathclients.restClient;

import org.springframework.web.service.annotation.GetExchange;

public interface FooClient {

    // navigation. completion here: doesn't work, worked previously
    @GetExchange("/foo/test1")
    String test1();
    @GetExchange("/foo/test2")
    String test2();
}
