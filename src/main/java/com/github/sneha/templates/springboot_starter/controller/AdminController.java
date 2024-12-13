package com.github.sneha.templates.springboot_starter.controller;

import com.github.sneha.templates.springboot_starter.advice.LogExecutionTime;
import io.swagger.v3.oas.annotations.Operation;
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


    @DeleteMapping("/clearAllCache")
    @Operation(summary = "Clear Cache", description = "Clear the redis cache")
    @LogExecutionTime
    public String clearRedisCache(){
        return "Success";
    }

}