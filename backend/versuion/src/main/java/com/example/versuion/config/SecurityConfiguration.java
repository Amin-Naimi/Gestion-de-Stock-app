package com.example.versuion.config;

import com.example.versuion.jwt.JwtRequestFiltre;
import com.example.versuion.services.auth.ApplicationUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
/*@EnableWebSecurity ccontient
@configuration
:*/

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private ApplicationUserDetailsService applicationUserDetailsService;

    @Autowired
    private JwtRequestFiltre jwtRequestFiltre;

    //Chercher les informations de l'utilisateurs dans la base de donner
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(applicationUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
        http.csrf().disable()//desactiver le csrf
        .authorizeRequests()
                .antMatchers("/**/auth/authentification",
                        "/**/utilisateurs/create",
                        "/**/articles/create",
                        "/**/categories/**",
                        "/v2/api-docs",
                        "/swagger-resources",
                        "/swagger-resources/**",
                        "/configuration/ui",
                        "/configuration/security",
                        "/swagger-ui.html",
                        "/webjars/**",
                        "/v3/api-docs/**",
                        "/swagger-ui/**")
                .permitAll() //Autoriser cette requette
                .anyRequest()
                .authenticated()// pour le reste des requettes il faut que l' user s'autentifer
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Utiliser ce filtre avant d'executer les requettes
        http.addFilterBefore(jwtRequestFiltre, UsernamePasswordAuthenticationFilter.class);

    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}


//// ctrl + alt + l