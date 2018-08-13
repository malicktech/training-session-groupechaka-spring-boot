package com.chaka.demo.metrics;

import java.util.Random;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * Custom health indicator 
 * 
 * @author citizendiop
 *
 */
@Component
public class DemoHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
		// perform some specific health check
		boolean result = check();
		if (!result)
			return Health.down().withDetail("Random().nextBoolean()", result).build();
		else
			return Health.up().build();
	}

	public boolean check() {
		// Our logic to check health
		return new Random().nextBoolean();
	}
}
