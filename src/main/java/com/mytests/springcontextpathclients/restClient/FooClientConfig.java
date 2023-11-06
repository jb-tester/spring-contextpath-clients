package com.mytests.springcontextpathclients.restClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class FooClientConfig {
    @Bean
    public FooClient fooClient() {

        RestClient client = RestClient.builder().baseUrl("http://localhost:8081/spring/tests").build();

        HttpServiceProxyFactory proxyFactory =
                HttpServiceProxyFactory.builderFor(RestClientAdapter.create(client)).build();

        return proxyFactory.createClient(FooClient.class);
    }
}
