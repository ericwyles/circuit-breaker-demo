package com.ericwyles.circuitbreakerdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
public class Application {
	private HelloService helloService;
	public Application(HelloService helloService) {
		this.helloService = helloService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping("/endpoint1")
	public String endpoint1Implementation() {
		return helloService.getHello1Output();
	}

	@GetMapping("/endpoint2")
	public String endpoint2Implementation(){
		return helloService.getHello2Output();
	}
}
