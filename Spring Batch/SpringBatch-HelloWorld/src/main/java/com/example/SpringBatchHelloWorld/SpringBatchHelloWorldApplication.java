package com.example.SpringBatchHelloWorld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.example.SpringBatchHelloWorld.configuration.JobConfiguration;

@SpringBootApplication
@Import(JobConfiguration.class)
public class SpringBatchHelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchHelloWorldApplication.class, args);
	}

}
