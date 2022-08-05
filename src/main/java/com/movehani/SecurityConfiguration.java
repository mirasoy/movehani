package com.movehani;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        .csrf().disable()
		.authorizeRequests()
		.antMatchers("/", "/postlist/**", "/post/**" ,  "/account/login").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
			.loginPage("/member/login")
			.permitAll()
			.and()
		.logout()
			.logoutUrl("/member/logout")
			.logoutSuccessUrl("/member/login")
			.permitAll();
		//	.and();
		//.userDetailsService(userDetailsService);
        return http.build();
    }

    
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/resource/css/*",  "/resource/js/*");
    }
    
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
    	UserDetails  user = User.withDefaultPasswordEncoder()
            .username("user")
            .password("password")
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user);
    }
}