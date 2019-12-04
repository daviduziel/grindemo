package com.grinexample.grindemo.config;

import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@AutoConfigurationPackage
@ComponentScan(basePackages = { "com.grinexample.grindemo.config", "com.grinexample.grindemo.service.impl",
		"com.grinexample.grindemo.controller", "com.grinexample.grindemo.dao" })
@EnableJpaRepositories(basePackages = "com.grinexample.grindemo.dao")
@EntityScan(basePackages = "com.grinexample.grindemo.model")
public class MainConfig {

}
