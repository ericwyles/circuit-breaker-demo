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

    String getHello1Output() {
        log.info("Executing endpoint1.");
        slownessSimulator.toggle();
        slownessSimulator.sleep();
        return "Hello from endpoint 1";
    }

    String getHello2Output() {
        return "Hello from endpoint2";
    }
}
