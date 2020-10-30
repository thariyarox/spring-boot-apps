package com.amplify.schoolapp.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class AppHealthIndicator implements HealthIndicator {

    private final String message_key = "AppService";
    @Override
    public Health health() {

        if(!isRunning()){
            return Health.down().withDetail(message_key, "Not Available").build();
        }

        return Health.up().withDetail(message_key, "Available").build();
    }

    private boolean isRunning() {

        //logic here
        return false;
    }
}
