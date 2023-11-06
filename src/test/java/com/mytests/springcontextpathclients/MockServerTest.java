package com.mytests.springcontextpathclients;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.matchers.Times;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import static org.mockserver.model.StringBody.exact;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@SpringBootTest
public class MockServerTest {
    private static ClientAndServer mockServer;
    @Resource
    private Environment environment;
    @Resource
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = webAppContextSetup(webApplicationContext).build();
        mockServer = startClientAndServer(8081);

    }

    @Test
    void testBarMappings() throws Exception {
        mockServer.when(
                        request()
                                .withPath("/spring/tests/bar/test3")
                                .withMethod("GET")
                        , Times.exactly(1))

                .respond(response()
                        .withBody(exact("test"))
                );
         // completion and navigation uses prefix; actually the prefix should be omitted here
        //MvcResult myresponse = mockMvc.perform(get("/spring/tests/feignClient/bar/test3"))
        MvcResult myresponse = mockMvc.perform(get("/feignClient/bar/test3"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain; charset=utf-8"))
                .andReturn();

        assertEquals(myresponse.getResponse().getContentAsString(),"test");


    }
}
