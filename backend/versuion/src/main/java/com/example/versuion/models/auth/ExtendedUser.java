package com.example.versuion.models.auth;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class ExtendedUser extends User {

    @Getter
    @Setter
    private Long idEntreprise;

    public ExtendedUser(String email, String password,
                        Collection<? extends GrantedAuthority> authorities) {
        super(email, password, authorities);
    }

    public ExtendedUser(String email, String password, Long idEntreprise ,
                        Collection<? extends GrantedAuthority> authorities) {
        super(email, password, authorities);
        this.idEntreprise = idEntreprise;
    }
}
