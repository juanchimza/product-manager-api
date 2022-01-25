package com.falabella.product.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

   private static final String USER_COMMON = "USER";
   private static final String USER_ADMIN = "ADMIN";
   private final PasswordEncoder passwordEncoder;

   public WebSecurityConfig(@Autowired PasswordEncoder passwordEncoder) {
      this.passwordEncoder = passwordEncoder;
   }

   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http.httpBasic()
          .and().authorizeRequests()
          .antMatchers(HttpMethod.GET, "/products").hasAnyRole(USER_COMMON,USER_ADMIN)
          .antMatchers(HttpMethod.GET, "/products/{sku}/sku").hasAnyRole(USER_COMMON,USER_ADMIN)
          .antMatchers(HttpMethod.POST, "/products").hasRole(USER_ADMIN)
          .antMatchers(HttpMethod.POST, "/products/{sku}/sku").hasRole(USER_ADMIN)
          .and()
          .csrf().disable()
          .formLogin().disable();
   }

   @Bean
   @Override
   public UserDetailsService userDetailsService() {
      UserDetails user =
            User.builder()
                .username("falabella_user")
                .password(passwordEncoder.encode("falabella_pass"))
                .roles(USER_COMMON)
                .build();
      UserDetails admin =
            User.builder()
                .username("falabella_admin")
                .password(passwordEncoder.encode("falabella_pass"))
                .roles(USER_ADMIN)
                .build();

      return new InMemoryUserDetailsManager(user,admin);
   }
}