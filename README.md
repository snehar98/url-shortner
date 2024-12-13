# springboot-starter

This is a **Spring Boot Starter Project** configured with essential features such as **Spring Security**, **Redis**, and **OpenAPI** (Swagger) documentation. It provides a base template for quickly setting up Java applications with commonly used configurations.

## Features
- **Spring Security** for authentication and authorization
- **Redis** for caching and data storage (configured with default settings)
- **MySQL** for relational database support (optional configuration)
- **OpenAPI** for API documentation using Swagger
- **Actuator** for application monitoring

## Prerequisites
Before running the application, ensure that you have the following installed:
- **JDK 17** or higher
- **Gradle** (depending on your build tool)
- **Redis** server (Optional)
- **MySQL** server (Optional)

## Setup and Installation

### 1. Clone the Repository

```bash
git clone https://github.com/snehar98/springboot-starter-project.git
cd springboot-starter-project
```

### 2. Configure Redis (Optional)
If you're using a Redis server locally or remotely, you can configure it in the application.yml file.

application.yml
```bash
spring:
  redis:
    host: localhost   # Default Redis host (can be left out if using the default)
    port: 6379        # Default Redis port (can be left out if using the default)
    password: yourpassword  # Optional: provide the password if Redis is secured
    timeout: 2000ms    # Optional: connection timeout
    jedis: #If Jedis connection pool is used
      pool:
        max-active: 10  # Maximum number of connections in the pool
        max-idle: 5     # Maximum number of idle connections in the pool
        min-idle: 1     # Minimum number of idle connections in the pool
```
Add required classes based on requirement

### 3. Configure MySQL
If you want to use MySQL as your database, uncomment the following configurations in the code:

build.gradle
```bash
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation group: 'mysql', name: 'mysql-connector-java', version: '8.0.28'
```
application.yml
```bash
  datasource:
    url: jdbc:mysql://localhost:3306/mydatabase #create the database with appropriate name
    username: root
    password:
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    hibernate.ddl-auto: none
    #generate-ddl: false #Disable schema management
    #show-sql: true #Log SQL queries
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQL8Dialect
        #generate_statistics: true #Monitor Hibernate performance
```
Add required classes based on requirement

### 4.API Documentation

**Swagger UI**
http://localhost:8080/swagger-ui/index.html

**Application endpoints**
* Go to Swagger UI (above link)
* Servers --> localhost:8080 - Application Server 
* Definition -> springDocDefault

**Actuator endpoints**
* Go to Swagger UI (above link)
* Servers --> localhost:9000 - Management Server
* Definition --> x-actuator

**API Docs**
http://localhost:8080/v3/api-docs

### 5.Security Configuration
* The application utilizes Spring Security to manage authentication for different endpoints.
* Authentication is based on username and password. The credentials are defined in application.yml and are required to access secured endpoints, particularly those in the admin controller. 
* For adding new endpoints:
  * Whitelist endpoints by modifying the SecurityConfig class, where specific paths can be allowed or restricted. 
  * Admin endpoints should be explicitly whitelisted using requestMatchers with role-based access control (RBAC) to ensure only ADMIN users can access those paths. 
  * For general access, endpoints can be whitelisted using the first requestMatchers clause without role-based restrictions.
```bash
 @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests()
                .requestMatchers("/swagger-ui/*", "/v3/api-docs","/v3/api-docs/*", "/swagger-resources/*", "/webjars/*","/actuator/*","/error",
                        "/favicon.ico")
                .permitAll()
                .requestMatchers("/admin/*")
                .permitAll()
                .anyRequest()
                .authenticated();;
        // Allow all other paths

        return http.build();
    }
```
* The application.yml and SecurityConfig files can be customized to enhance or modify security settings, such as enabling/disabling specific authentication methods or refining access control policies.

### 6.Build and Run the Application
```bash
./gradlew build
./gradlew bootRun
```