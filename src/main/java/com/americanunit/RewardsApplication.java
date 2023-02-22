package com.americanunit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude= {UserDetailsServiceAutoConfiguration.class, SecurityAutoConfiguration.class })
public class RewardsApplication {
	public static void main(String[] args) {
		SpringApplication.run(RewardsApplication.class, args);
	}


}
