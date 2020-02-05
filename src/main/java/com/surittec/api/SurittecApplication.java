package com.surittec.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.surittec.api.config.property.ApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(ApiProperty.class)
public class SurittecApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurittecApplication.class, args);
	}

}
