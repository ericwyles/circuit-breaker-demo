package com.ericwyles.circuitbreakerdemo;

import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.circuitbreaker.event.CircuitBreakerEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@Slf4j
public class CircuitBreakerLoggingConfig {
    @Bean
    public BeanPostProcessor circuitBreakerRegistryPostProcessor() {
        return new BeanPostProcessor() {
            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                return bean;
            }

            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (bean instanceof CircuitBreakerRegistry) {
                    CircuitBreakerRegistry circuitBreakerRegistry = (CircuitBreakerRegistry)bean;
                    circuitBreakerRegistry.circuitBreaker("endpoint1CircuitBreaker")
                            .getEventPublisher().
                            onEvent(event -> {
                                    if (event.getEventType() == CircuitBreakerEvent.Type.STATE_TRANSITION) {
                                        String state = circuitBreakerRegistry.circuitBreaker(event.getCircuitBreakerName()).getState().toString();

                                        log.info("Circuit Breaker {} transition to state {}.",
                                                event.getCircuitBreakerName(),
                                                state);
                                    }
                            });
                }
                return bean;
            }
        };
    }
}
