package com.javamsdt.actuator.actuator;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DbHealthIndicatorTest {

    private static final String ENDPOINT_PATH = "/actuator/externalDbHealth";
    private static final String UP_RESPONSE = "{\"External-Db-Health\":{\"status\":\"UP\",\"details\":{\"External Db Health\":\"Healthy and Up\"}}}";
    private static final String DOWN_RESPONSE = "{\"External-Db-Health\":{\"status\":\"DOWN\",\"details\":{\"External Db Health\":\"Is Not-Healthy\"}}}";

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private DbHealthIndicator dbHealthIndicator;

    @Test
    @WithMockUser(roles = "ADMIN")
    void test_call_to_endpoint_with_admin_role_success_up() throws Exception {
        when(dbHealthIndicator.getHealth(true)).thenReturn(Health.up().withDetail("External Db Health", "Healthy and Up").build());
        mockMvc
                .perform(MockMvcRequestBuilders.get(ENDPOINT_PATH))
                .andExpect(status().isOk())
                .andExpect(content().json(UP_RESPONSE));
    }
    @Test
    @WithMockUser(roles = "ADMIN")
    void test_call_to_endpoint_with_admin_role_success_down() throws Exception {
        // Health health = mock(Health.class);
        when(dbHealthIndicator.getHealth(false)).thenReturn(Health.down().withDetail("External Db Health", "Is Not-Healthy").build());
        mockMvc
                .perform(MockMvcRequestBuilders.get(ENDPOINT_PATH))
                .andExpect(status().isOk())
                .andExpect(content().json(DOWN_RESPONSE));
    }

    @Test
    @WithMockUser(roles = "")
    void test_call_to_endpoint_with_other_role_fail() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get(ENDPOINT_PATH))
                .andExpect(status().is4xxClientError());
    }
}
