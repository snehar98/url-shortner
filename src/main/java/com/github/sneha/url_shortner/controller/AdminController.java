package com.github.sneha.url_shortner.controller;

import com.github.sneha.url_shortner.advice.LogExecutionTime;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class handles administrative operations such as user management
 * and system configuration. It uses Spring Security for authentication
 * based on username and password.
 *
 * @author sneharavikumartl
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    CacheManager cacheManager;


    /**
     * Clears the Redis cache for users.
     * This operation will clear any cached user data stored in Redis under the "urls" cache.
     *
     * @return a message indicating successful cache clearance
     */
    @DeleteMapping("/clearAllCache")
    @Operation(summary = "Clear Cache", description = "Clears the Redis cache for urls.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cache successfully cleared"),
            @ApiResponse(responseCode = "500", description = "Error while clearing cache")
    })
    @LogExecutionTime // Custom annotation to log the execution time of this method
    public String clearRedisCache() {
        // Check if the cache for users exists, and if so, clear it
        if (cacheManager.getCache("urls") != null) {
            cacheManager.getCache("urls").clear();
        }
        return "Urls cache cleared successfully"; // Return success message after cache is cleared
    }
}