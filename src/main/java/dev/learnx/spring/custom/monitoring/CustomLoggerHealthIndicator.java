package dev.learnx.spring.custom.monitoring;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomLoggerHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {

        Map<String, String> loggerHealthIndicatorMap = new HashMap<>();
        loggerHealthIndicatorMap.put("Remote Logger Status", "Remote Logger is Down");
        loggerHealthIndicatorMap.put("Local Logger Status", "Remote Logger is Down");

        return Health.down().withDetails(loggerHealthIndicatorMap).build();
    }
}
