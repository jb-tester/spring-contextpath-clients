package com.mytests.springcontextpathclients.restClient;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;


@Service
public class BarClient {
    public void test3(){
        RestClient client = RestClient.builder().baseUrl("http://localhost:8081/spring/tests").build();
        String response = client.get()
                .uri("/bar/test3")  // ok
                .retrieve()
                .body(String.class);
        System.out.println("===== Trying /bar/test3: \n it returns \"" + response + "\"");
    }
}
