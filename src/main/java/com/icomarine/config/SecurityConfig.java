package com.icomarine.config;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SuppressFBWarnings(value = {"SPRING_CSRF_PROTECTION_DISABLED"})
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @SuppressFBWarnings(value = {"THROWS"})
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable();
//    http.authorizeRequests().anyRequest().authenticated();
//    http.formLogin();
//    http.httpBasic();

    http.headers()
        .xssProtection()
        .and()
        .contentSecurityPolicy(
            String.format(
                "script-src 'self' %s %s",
                "https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js",
                "https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"));
  }
}
