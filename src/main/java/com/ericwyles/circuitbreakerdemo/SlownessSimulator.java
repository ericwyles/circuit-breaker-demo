package com.ericwyles.circuitbreakerdemo;

import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
@Slf4j
public class SlownessSimulator {
    AtomicLong numCalls= new AtomicLong(0);
    boolean makeSlow=true;

    public void toggle() {
        if (numCalls.incrementAndGet() % 50 == 0) { // alternate the flag every 50 calls
            makeSlow = !makeSlow;
            log.info("makeSlow is {}", makeSlow);
        }
    }

    public void sleep() {
        if (makeSlow)
            Try.run(() -> Thread.sleep(30000)); // 30 seconds
        else
            Try.run(() -> Thread.sleep(15000)); // 15 seconds
    }
}
