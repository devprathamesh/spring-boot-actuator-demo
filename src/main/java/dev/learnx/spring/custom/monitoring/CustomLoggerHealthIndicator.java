package dev.learnx.spring.custom.monitoring;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//Disabling Component
//@Component
public class CustomLoggerHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        Random random = new Random();
        Map<String, String> loggerHealthIndicatorMap = new HashMap<>();
        if(random.nextBoolean()) {
            loggerHealthIndicatorMap.put("Remote Logger Status", "Remote Logger is Up");
            loggerHealthIndicatorMap.put("Local Logger Status", "Local Logger is Up");
            return Health.up().withDetails(loggerHealthIndicatorMap).build();
        }

        loggerHealthIndicatorMap.put("Remote Logger Status", "Remote Logger is Down");
        loggerHealthIndicatorMap.put("Local Logger Status", "Remote Logger is Down");
        return Health.down().withDetails(loggerHealthIndicatorMap).build();
    }
}
