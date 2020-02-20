package com.ericwyles.circuitbreakerdemo;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j

public class HelloService {
    private static final String ENDPOINT1 = "endpoint1";
    private SlownessSimulator slownessSimulator;

    public HelloService(SlownessSimulator slownessSimulator) {
        this.slownessSimulator = slownessSimulator;
    }

    @Bulkhead(name = ENDPOINT1)
    @CircuitBreaker(name = ENDPOINT1, fallbackMethod = "getHello1OutputFallback")
    String getHello1Output() {
        log.info("Executing endpoint1 Primary Path.");
        slownessSimulator.toggle(); // toggle the sleep time
        slownessSimulator.sleep(); // sleep
        return "Hello from endpoint 1";
    }

    private String getHello1OutputFallback(Exception ex) {
        log.info("Executing endpoint1 Fallback.");
        slownessSimulator.toggle(); // in the fallback we toggle but dont sleep
        return "HELLO SERVICE IS UNAVAILABLE. PLEASE TRY AGAIN LATER.";
    }

    String getHello2Output() {
        return "Hello from endpoint2";
    }
}
