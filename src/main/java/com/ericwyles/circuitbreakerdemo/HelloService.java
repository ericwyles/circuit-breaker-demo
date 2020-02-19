package com.ericwyles.circuitbreakerdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HelloService {
    private SlownessSimulator slownessSimulator;

    public HelloService(SlownessSimulator slownessSimulator) {
        this.slownessSimulator = slownessSimulator;
    }

    public String getHello1Output() {
        log.info("Executing endpoint1.");
        slownessSimulator.toggleAndSleep(true);
        return "Hello from endpoint 1";
    }

    public String getHello2Output() {
        return "Hello from endpoint2";
    }
}
