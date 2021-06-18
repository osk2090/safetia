package com.osk.safetia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan("com.osk.safetia")
@EnableWebMvc
@PropertySource("classpath:com/osk/safetia/config/jdbc.properties")
public class AppConfig {
    @Bean
}
