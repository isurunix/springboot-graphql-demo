/*
 * (C) Copyright 2009-2021 hSenid Software International (Pvt) Limited.
 * All Rights Reserved.
 *
 *  These materials are unpublished, proprietary, confidential source code of
 *  hSenid Software International (Pvt) Limited and constitute a TRADE SECRET
 *  of hSenid Software International (Pvt) Limited.
 *
 *  hSenid Software International (Pvt) Limited retains all title to and intellectual
 *  property rights in these materials.
 */

package com.isurunix.graphqldemo.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
@EnableConfigurationProperties(SecurityProperties.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final AuthenticationProvider authenticationProvider;
    private final JWTFilter jwtFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().permitAll()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .csrf().disable()
                .headers().frameOptions().sameOrigin()
                .and()
                .addFilterBefore(jwtFilter, RequestHeaderAuthenticationFilter.class);
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOriginPatterns(List.of("*"));
        config.setAllowedHeaders(List.of("*"));
        config.setAllowedMethods(List.of("*"));
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
