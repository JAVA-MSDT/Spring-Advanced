package com.javamsdt.actuator.actuator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DbHealthIndicatorTest {

    private static final String ENDPOINT_PATH = "/actuator/externalDbHealth";

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(roles = "ADMIN")
    void test_call_to_endpoint_with_admin_role_success() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get(ENDPOINT_PATH))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "")
    void test_call_to_endpoint_with_other_role_fail() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get(ENDPOINT_PATH))
                .andExpect(status().is4xxClientError());
    }
}
