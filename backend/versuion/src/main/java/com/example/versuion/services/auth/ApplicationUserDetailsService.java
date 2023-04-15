package com.example.versuion.services.auth;

import com.example.versuion.Dto.UtilisateurDto;
import com.example.versuion.exception.EntityNotFoundException;
import com.example.versuion.exception.ErrorCodes;
import com.example.versuion.models.Utilisateurs;
import com.example.versuion.models.auth.ExtendedUser;
import com.example.versuion.repository.UtilisateurRepository;
import com.example.versuion.services.UtilisateurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

//Chercher un utilisateur par son user name
@Service
@Slf4j
public class ApplicationUserDetailsService implements UserDetailsService {

    @Autowired
    private UtilisateurService utilisateurService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UtilisateurDto utilisateurs = utilisateurService.findByEmail(email);

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        utilisateurs.getRoles().forEach(
                role -> authorities.add(new SimpleGrantedAuthority(role.getRolename()))
        );

        //return new User(utilisateurs.getEmail(), utilisateurs.getMotDePasse(),Collections.EMPTY_LIST);
        return new ExtendedUser(utilisateurs.getEmail(), utilisateurs.getMotDePasse(), utilisateurs.getEntreprise().getId(), authorities);
    }
}
