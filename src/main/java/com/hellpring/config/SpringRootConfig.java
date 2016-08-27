package com.hellpring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.hellpring.service"})
public class SpringRootConfig {
}
