package com.ericwyles.circuitbreakerdemo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j

public class HelloService {
    SlownessSimulator slownessSimulator;

    public HelloService(SlownessSimulator slownessSimulator) {
        this.slownessSimulator = slownessSimulator;
    }

    @CircuitBreaker(name = "endpoint1CircuitBreaker", fallbackMethod = "getHello1OutputFallback")
    public String getHello1Output() {
        log.info("Executing endpoint1 Primary Path.");
        slownessSimulator.toggleAndSleep(true);
        return "Hello from endpoint 1";
    }

    private String getHello1OutputFallback(Exception ex) {
        log.info("Executing endpoint1 Fallback.");
        slownessSimulator.toggleAndSleep(false);
        return "HELLO SERVICE IS UNAVAILABLE. PLEASE TRY AGAIN LATER.";
    }

    public String getHello2Output() {
        return "Hello from endpoint2";
    }
}
