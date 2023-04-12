package com.example.versuion.services.auth;

import com.example.versuion.exception.EntityNotFoundException;
import com.example.versuion.exception.ErrorCodes;
import com.example.versuion.models.Utilisateurs;
import com.example.versuion.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

//Chercher un utilisateur par son user name
@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Utilisateurs utilisateurs = utilisateurRepository.findByEmail(email).orElseThrow(
                ()-> new EntityNotFoundException("Aucun utilisateur avec l'email fournit", ErrorCodes.UTILISATEUR_NOT_FOUND)
        );

        return new User(utilisateurs.getEmail(), utilisateurs.getMotDePasse(), Collections.EMPTY_LIST);
    }
}
