package by.shulga.diplomaproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .authorizeRequests((auth)-> auth
                        .requestMatchers("/", "/upload")
                        .permitAll()
                        .requestMatchers("/hello").hasRole("USER")
                        .anyRequest()
                        .authenticated())
                .formLogin()
                .loginPage("/login")
                .successForwardUrl("/hello")
                .defaultSuccessUrl("/hello")
                .permitAll()
                .and()
                .logout()
                //.logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .permitAll();

        return http.build();
    }
    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("login_user")
                .password("password")
                .roles("USER")
                .build();

        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("login_admin")
                .password("password2")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user,user2);
    }

}