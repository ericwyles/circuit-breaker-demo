package com.ericwyles.circuitbreakerdemo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
@Slf4j

public class HelloService {
    AtomicLong numCalls= new AtomicLong(0);
    boolean makeSlow=true;

    @CircuitBreaker(name = "endpoint1CircuitBreaker", fallbackMethod = "getHello1OutputFallback")
    public String getHello1Output() {
        log.info("Executing endpoint1 Primary Path.");
        slowtoggle(true); // toggle slow and sleep for long or short amount of time
        return "Hello from endpoint 1";
    }

    private String getHello1OutputFallback(Exception ex) {
        log.info("Executing endpoint1 Fallback.");
        slowtoggle(false); // toggle slow boolean but don't sleep
        return "HELLO SERVICE IS UNAVAILABLE. PLEASE TRY AGAIN LATER.";
    }

    public String getHello2Output() {
        return "Hello from endpoint2";
    }

    private boolean slowtoggle(boolean sleep) {
        if (numCalls.incrementAndGet() % 50 == 0) { // alternate the flag every 50 calls
            makeSlow = !makeSlow;
            log.info("makeSlow is {}", makeSlow);
        }

        if (sleep) {
            if (makeSlow)
                Try.run(() -> Thread.sleep(30000)); // 30 seconds
            else
                Try.run(() -> Thread.sleep(15000)); // 15 seconds
        }

        return makeSlow;
    }
}
