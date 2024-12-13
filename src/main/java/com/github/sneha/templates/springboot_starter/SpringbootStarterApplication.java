package com.github.sneha.templates.springboot_starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * This is starter template for spring boot projects.
 * This contains essential configurations and common dependencies for building
 * modern java applications
 *
 * @author sneharavikumartl
 */

@EnableCaching
@SpringBootApplication
public class SpringbootStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootStarterApplication.class, args);
	}

}
