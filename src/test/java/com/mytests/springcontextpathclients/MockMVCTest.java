package com.mytests.springcontextpathclients;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class MockMVCTest {

    @Autowired
    private MockMvc mockMvc;

    // incorrect completion (prefix is suggested), broken navigation
    // previously: completion is incorrect, but navigation works
    @Test
    public void test1() throws Exception {
        this.mockMvc.perform(get("/buzz/test1"))
                .andDo(print()).andExpect(status().isOk());
    }
}
