package com.mytests.springcontextpathclients;

import com.mytests.springcontextpathclients.restClient.BarClient;
import com.mytests.springcontextpathclients.restClient.FooClient;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
@EnableFeignClients
public class SpringContextpathClientsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringContextpathClientsApplication.class, args);
    }


    /*@Bean
    public ApplicationRunner applicationRunner(FooClient fooClient, BarClient barClient) {
        return args -> {
            System.out.println("===== Trying /foo/test1: \n it returns \"" + fooClient.test1() + "\"");
            System.out.println("===== Trying /foo/test2: \n it returns \"" + fooClient.test2() + "\"");
            barClient.test3();
              };
    }*/

}
