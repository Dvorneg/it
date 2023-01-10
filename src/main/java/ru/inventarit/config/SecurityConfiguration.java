package ru.inventarit.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.inventarit.model.User;
import ru.inventarit.repository.UserRepository;
import ru.inventarit.util.JsonUtil;
import ru.inventarit.web.AuthUser;

import java.util.Optional;

@Configuration
@EnableWebSecurity
@Slf4j
@AllArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)//?
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {
public class SecurityConfiguration {

    public static final PasswordEncoder PASSWORD_ENCODER = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    private final UserRepository userRepository;

    @Autowired
    private void setMapper(ObjectMapper objectMapper) {
        JsonUtil.setMapper(objectMapper);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

/*    @Bean
    @Override
    // https://stackoverflow.com/a/70176629/548473
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }*/

    //@Override
    protected UserDetailsService userDetailsService() {
        return email -> {
            log.debug("Authenticating '{}'", email);
            Optional<User> optionalUser = userRepository.findByEmailIgnoreCase(email);
            return new AuthUser(optionalUser.orElseThrow(
                    () -> new UsernameNotFoundException("User '" + email + "' was not found")));
        };
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
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

/*    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/resources/css/**").permitAll()
                .antMatchers("/resources/images/**").permitAll()
                 //.antMatchers("/profile/**").anonymous()
                .antMatchers("/login/**").anonymous()
                .antMatchers("/profile/register","/webjars/**").permitAll()
                .antMatchers("/about","/about").permitAll()
                .antMatchers("/WEB-INF/lib/**").permitAll()
                .antMatchers("/**").authenticated()
                // .antMatchers("/", "/resources/**").permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/login")  .permitAll()
                .loginProcessingUrl("/spring_security_check")
                .failureUrl("/login?error=true")//
                .and().logout().permitAll()
                .and().csrf().disable() ;

    }*/
}