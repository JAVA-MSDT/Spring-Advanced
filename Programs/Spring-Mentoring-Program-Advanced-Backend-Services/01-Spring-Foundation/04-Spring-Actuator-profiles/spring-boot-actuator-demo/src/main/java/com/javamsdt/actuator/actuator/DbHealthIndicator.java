package com.javamsdt.actuator.actuator;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Endpoint(id = "externalDbHealth")
@Component
public class DbHealthIndicator implements HealthIndicator {

    @Override
    public Health getHealth(boolean includeDetails) {
        return HealthIndicator.super.getHealth(includeDetails);
    }

    @Override
    public Health health() {
        return isDbHealthy() ? Health.up().withDetail("External Db Health", "Healthy and Up").build()
                : Health.down().withDetail("External Db Health", "Is Not-Healthy").build();
    }

    @ReadOperation
    public Map<String, Health> healthEndPoint() {
        Map<String, Health> healthEndPoint = new HashMap<>();
        healthEndPoint.put("External-Db-Health", health());
        return healthEndPoint;
    }

    private boolean isDbHealthy() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
