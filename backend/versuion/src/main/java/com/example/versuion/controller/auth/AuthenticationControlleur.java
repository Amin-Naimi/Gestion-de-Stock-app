package com.example.versuion.controller.auth;

import com.example.versuion.Dto.auth.AuthenticationRequest;
import com.example.versuion.Dto.auth.AuthenticationResponse;
import com.example.versuion.jwt.JwtUtil;
import com.example.versuion.models.auth.ExtendedUser;
import com.example.versuion.services.auth.ApplicationUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.versuion.utiles.Constants.AUTHENTICATION_ENDPOINT;

@RestController
@RequestMapping(AUTHENTICATION_ENDPOINT)
public class AuthenticationControlleur {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ApplicationUserDetailsService applicationUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;



    //Authentifier user qui va connecter
    @PostMapping("/authentification")
    public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest request){
        // verifier le mot de passe et le login
        // Elle renvoie une exception de type BadCredantielsException
        // l'exception sera catcher automatiquement avec la classe "RestExceptionHandler"
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                )
        );
        final UserDetails userDetails = applicationUserDetailsService.loadUserByUsername(request.getLogin());
        final String jwt = jwtUtil.generateToken((ExtendedUser)userDetails);

        return AuthenticationResponse.builder().accessToken(jwt).build();
    }
}
