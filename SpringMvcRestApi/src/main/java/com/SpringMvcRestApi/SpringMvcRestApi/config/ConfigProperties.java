package com.SpringMvcRestApi.SpringMvcRestApi.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix = "demo")
public class ConfigProperties {

    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;

}
