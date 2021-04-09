package com.SpringMvcRestApi.SpringMvcRestApi;

import com.SpringMvcRestApi.SpringMvcRestApi.config.ConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(ConfigProperties.class)
@SpringBootApplication
public class SpringMvcRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcRestApiApplication.class, args);
	}

}
