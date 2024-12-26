package com.github.sneha.url_shortner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * This is the main entry point for the URL Shortener Application.
 * The application provides functionality to convert long URLs into short URLs,
 * manage URL redirection, and track access statistics. It also includes
 * configurations for caching, persistence, and API documentation.
 *
 * @author sneharavikumartl
 */
@EnableCaching
@SpringBootApplication
public class UrlShortnerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlShortnerApplication.class, args);
	}

}
