package com.github.sneha.url_shortner.controller;

import com.github.sneha.url_shortner.service.UrlShortnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling URL shortening requests.
 * This class exposes the endpoint to shorten a given long URL.
 * It delegates the logic to the UrlShortnerService.
 *
 * @author sneharavikumartl
 */
@RestController
@RequestMapping("/urls")
public class UrlsController {

    @Autowired
    private UrlShortnerService urlShortnerService;

    /**
     * Endpoint to shorten a given long URL.
     * This method receives a long URL as a path variable, calls the UrlShortnerService to get the shortened URL,
     * and returns the shortened URL as the response.
     *
     * @param longUrl the original long URL to shorten
     * @return the ResponseEntity containing the shortened URL
     */
    @GetMapping("/shortenUrl/{longUrl}")
    public ResponseEntity<String> getShortUrl(@PathVariable String longUrl){
        return ResponseEntity.ok(urlShortnerService.getShortUrl(longUrl)); // Return the short URL in the response
    }
}
