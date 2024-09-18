package com.movie.project.MovieTicket.security;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    // add support for JDBC ... no more hardcoded users :-)

	@Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
       // define query to retrieve a user by username
       jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select username,password,active from users where username=?");
      
       // define query to retrieve the authorities/roles by username
       jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
               "select u.username,r.role from users u,roles r where u.user_id=r.user_id and username=?");
        return jdbcUserDetailsManager;
   }
	
@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http.authorizeHttpRequests(configurer ->
    configurer

    		.requestMatchers(HttpMethod.POST,"/api/admin").permitAll()
    		.requestMatchers(HttpMethod.GET,"/api/admin").permitAll()
    		.requestMatchers(HttpMethod.GET,"/api/admin/{admin_id}").permitAll()
    		.requestMatchers(HttpMethod.PUT,"/api/admin").permitAll()
    		.requestMatchers(HttpMethod.DELETE,"/api/admin").permitAll()
    		.requestMatchers(HttpMethod.DELETE,"/api/admin/{admin_id}").permitAll()

    		.requestMatchers(HttpMethod.POST,"/api/customer").permitAll()
    		.requestMatchers(HttpMethod.GET,"/api/customer").permitAll()
    		.requestMatchers(HttpMethod.GET,"/api/customer/{customer_id}").permitAll()
    		.requestMatchers(HttpMethod.PUT,"/api/customer").permitAll()
    		.requestMatchers(HttpMethod.DELETE,"/api/customer").permitAll()
    		.requestMatchers(HttpMethod.DELETE,"/api/customer/{customer_id}").permitAll()
    		
    		.requestMatchers(HttpMethod.POST,"/api/ticket/{movie_id}/{customer_id}").permitAll()
    		.requestMatchers(HttpMethod.GET,"/api/ticket").permitAll()
    		.requestMatchers(HttpMethod.GET,"/api/ticket/{ticket_id}").permitAll()
    		.requestMatchers(HttpMethod.PUT,"/api/ticket/{movie_id}/{customer_id}").permitAll()
    		.requestMatchers(HttpMethod.DELETE,"/api/ticket").permitAll()
    		.requestMatchers(HttpMethod.DELETE,"/api/ticket/{ticket_id}").permitAll()
    		
    		.requestMatchers(HttpMethod.POST,"/api/addCustomerUser").permitAll()
    		.requestMatchers(HttpMethod.POST,"/api/addAdminUser").permitAll()

    		
            .requestMatchers(HttpMethod.POST,"/api/movies").hasRole("ADMIN")
            .requestMatchers(HttpMethod.GET,"/api/movies").hasRole("ADMIN")
            .requestMatchers(HttpMethod.GET,"/api/movies/{movies_id}").hasRole("ADMIN")
            .requestMatchers(HttpMethod.PUT,"/api/movies").hasRole("ADMIN")
            .requestMatchers(HttpMethod.DELETE,"/api/movies").hasRole("ADMIN")
//            .requestMatchers(HttpMethod.DELETE,"/api//movies/{movies_id}").hasRole("ADMIN")
            
);

        // use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSRF)
        // in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
        http.csrf(csrf -> csrf.disable());

        return http.build();
        }
}
