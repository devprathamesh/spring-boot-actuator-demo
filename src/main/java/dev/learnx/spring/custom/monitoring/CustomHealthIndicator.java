package dev.learnx.spring.custom.monitoring;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import java.util.Random;

//Disabling Component
//@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        Random random = new Random();
        if(random.nextBoolean()) {
            return Health.up().withDetail("Application Status", "Application is Up").build();
        }
        return Health.down().withDetail("Application Status", "Application is Up").build();
    }
}
