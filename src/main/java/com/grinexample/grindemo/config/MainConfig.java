package com.grinexample.grindemo.config;

import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigurationPackage
@ComponentScan(basePackages = { "com.grinexample.grindemo.config", "com.grinexample.grindemo.service.impl",
		"com.grinexample.grindemo.controller", "com.grinexample.grindemo.dao" })
public class MainConfig {

}
