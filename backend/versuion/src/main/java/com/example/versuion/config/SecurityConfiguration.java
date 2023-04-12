package com.example.versuion.config;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.example.versuion.services.auth.ApplicationUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
/*@EnableWebSecurity ccontient :
* @Configuration
 */
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private  ApplicationUserDetailsService applicationUserDetailsService;

    //Chercher les informations de l'utilisateurs dans la base de donner
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(applicationUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()//desactiver le csrf
                .authorizeRequests().antMatchers("/**/authentification").permitAll() //Autoriser cette requette
                .anyRequest().authenticated();// pour le reste des requettes il faut sue user s'autentifer
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

}
