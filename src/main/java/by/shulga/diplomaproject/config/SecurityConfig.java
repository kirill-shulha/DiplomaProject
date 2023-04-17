package by.shulga.diplomaproject.config;

import by.shulga.diplomaproject.jvt.JwtFilter1;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtFilter1 jwtFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .cors().disable()
                .authorizeRequests((auth)-> auth
                        .requestMatchers("/cars/**","/swagger-ui/**","/v3/api-docs/**", "/upload",
                                "/registration", "/login")
                        .permitAll()
                        .requestMatchers("/cars2/**").hasRole("USER")
                        .anyRequest()
                        .authenticated()
                .and()

                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class));
        return http.build();
    }
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService(){
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("login_user")
//                .password("password")
//                .roles("USER")
//                .build();

//        UserDetails user2 = User.withDefaultPasswordEncoder()
//                .username("login_admin")
//                .password("password2")
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user,user2);
//    }

}