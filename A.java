/**
 * Provides an in-memory user store with an admin user.
 * The method creates a user with a username and password, encodes the password, 
 * and returns the user details. It throws an exception if an unauthorized user is requested.
 *
 * @return UserDetailsService instance that handles authentication for the admin user.
 * @throws RuntimeException if an unauthorized user is requested.
 * @author sneharavikumartl
 */
@Bean
public UserDetailsService userDetailsService() {
    UserDetails adminUser = User.withUsername(adminUsername)
            .password(passwordEncoder().encode(adminPassword))
            .build();
    return username -> {
        if (adminUsername.equals(username)) {
            return adminUser;
        }
        throw new RuntimeException("Unauthorized User");
    };
}

/**
 * Provides a PasswordEncoder bean to encode passwords using BCrypt.
 * This bean is used to securely encode user passwords before storing them.
 *
 * @return PasswordEncoder instance that uses BCrypt hashing algorithm.
 * @author sneharavikumartl
 */
@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}

/**
 * Configures and provides an AuthenticationManager bean.
 * The AuthenticationManager is responsible for authenticating users based on their credentials.
 * It uses the user details service and password encoder for authentication.
 *
 * @param http HttpSecurity configuration used to access shared AuthenticationManagerBuilder.
 * @return AuthenticationManager instance configured with the user details service and password encoder.
 * @throws Exception if authentication configuration fails.
 * @author sneharavikumartl
 */
@Bean
public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
    AuthenticationManagerBuilder authenticationManagerBuilder =
            http.getSharedObject(AuthenticationManagerBuilder.class);
    authenticationManagerBuilder.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    return authenticationManagerBuilder.build();
}

/**
 * Configures HTTP security settings using a SecurityFilterChain bean.
 * This method defines the paths that should be publicly accessible and others that require authentication.
 * It also disables CSRF and allows access to Swagger, actuator, and error endpoints.
 *
 * @param http HttpSecurity configuration to define security filters for HTTP requests.
 * @return SecurityFilterChain instance with the security configuration.
 * @throws Exception if configuration fails.
 * @author sneharavikumartl
 */
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
            .csrf(csrf -> csrf.disable())
            .authorizeRequests()
            .requestMatchers("/swagger-ui/*", "/v3/api-docs","/v3/api-docs/*", "/swagger-resources/*", "/webjars/*","/actuator/*","/error",
                    "/favicon.ico")
            .permitAll()
            .requestMatchers("/admin/*")//.hasRole("ADMIN")  // Only 'ADMIN' users can access this path
            .permitAll()
            .anyRequest()
            .authenticated();;
            // Allow all other paths

    return http.build();
}
