package ru.inventarit.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import ru.inventarit.util.JsonUtil;



@Configuration
@EnableWebSecurity
@Slf4j
@AllArgsConstructor
public class SecurityConfiguration {

    public static final PasswordEncoder PASSWORD_ENCODER = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    private final UserDetailsService  userDetailsService;

    @Autowired
    private void setMapper(ObjectMapper objectMapper) {
        JsonUtil.setMapper(objectMapper);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(PASSWORD_ENCODER);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/resources/css/**").permitAll()
                .antMatchers("/resources/images/**").permitAll()
                //.antMatchers("/profile/**").anonymous()
                .antMatchers("/login/**").anonymous()
                .antMatchers("/profile/register","/webjars/**").permitAll()
                .antMatchers("/about","/about").permitAll()
                .antMatchers("/WEB-INF/lib/**").permitAll()
                .antMatchers("/profile/register").permitAll()
                .antMatchers("/feedback/**").permitAll()
                .antMatchers("/**").authenticated()
                // .antMatchers("/", "/resources/**").permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/login")  .permitAll()
                .loginProcessingUrl("/spring_security_check")
                .failureUrl("/login?error=true")//
                .and().logout().permitAll()
                .and().csrf().disable() ;
        return http.build();
    }
}