package com.example.springBoot.SpringBootExamples.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.example.springBoot"})// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class SpringBootRestApiApp {

	public SpringBootRestApiApp() {
		// TODO Auto-generated constructor stub

	}
	
	public static void main(String[] args) {
        SpringApplication.run(SpringBootRestApiApp.class, args);
    }

}
