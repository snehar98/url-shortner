package com.github.sneha.url_shortner.controller;

import com.github.sneha.url_shortner.exception.InvalidUrlException;
import com.github.sneha.url_shortner.model.UrlShortnerRequest;
import com.github.sneha.url_shortner.service.UrlShortnerService;
import com.github.sneha.url_shortner.utils.Validator;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
     * This method receives a long URL in the request body, validates the URL,
     * calls the UrlShortnerService to generate a shortened URL, and returns it as the response.
     * If the provided URL is invalid, an InvalidUrlException is thrown.
     *
     * @param urlShortnerRequest the request object containing the original long URL to be shortened
     * @return the ResponseEntity containing the shortened URL
     * @throws InvalidUrlException if the provided URL is not valid
     */
    @PostMapping("/shortenUrl")
    public ResponseEntity<String> getShortUrl(@RequestBody UrlShortnerRequest urlShortnerRequest) {
        if (!Validator.isValidUrl(urlShortnerRequest.getLongUrl())) {
            throw new InvalidUrlException();
        }
        return ResponseEntity.ok(urlShortnerService.getShortUrl(urlShortnerRequest.getLongUrl())); // Return the short URL in the response
    }
}
