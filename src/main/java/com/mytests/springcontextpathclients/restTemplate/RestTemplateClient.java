package com.mytests.springcontextpathclients.restTemplate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

@Service
public class RestTemplateClient {

    public void fooTest1(){
        System.out.println("FooController endpoints: Trying /fooTest1 : url as value, no pathvars");
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response
                = restTemplate.getForEntity("http://localhost:8081/spring/tests/foo/test1", String.class);
        // navigation works, completion doesn't work (not a regression?):
        HttpHeaders httpHeaders = restTemplate.headForHeaders("http://localhost:8081/spring/tests/foo/test1");
        Set<HttpMethod> optionsForAllow = restTemplate.optionsForAllow("http://localhost:8081/spring/tests/foo/test1");

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
        System.out.println(httpHeaders.getContentType());
        System.out.println(optionsForAllow);
    }
}
