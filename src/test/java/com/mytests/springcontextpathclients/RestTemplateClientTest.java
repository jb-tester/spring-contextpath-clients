package com.mytests.springcontextpathclients;

import com.mytests.springcontextpathclients.restTemplate.RestTemplateClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestTemplateClientTest {


    @Autowired
    private RestTemplateClient restTemplateClient;

    // run application before running this test
    @Test
    void fooRestTemplateTest() {
        restTemplateClient.fooTest1();
    }
}
