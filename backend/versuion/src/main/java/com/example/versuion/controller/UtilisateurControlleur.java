package com.example.versuion.controller;

import com.example.versuion.Dto.ChangerMotDePasseUtilisateurDto;
import com.example.versuion.Dto.UtilisateurDto;
import com.example.versuion.controller.api.UtilisateurApi;
import com.example.versuion.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UtilisateurControlleur implements UtilisateurApi {

    UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurControlleur(UtilisateurService utilisateurService){
        this.utilisateurService = utilisateurService;
    }

    @Override
    public String save(UtilisateurDto dto) {
        return utilisateurService.save(dto).toString();
    }

    @Override
    public UtilisateurDto findById(Long id) {
        return utilisateurService.findById(id);
    }

    @Override
    public UtilisateurDto findByEmail(String email) {
        return utilisateurService.findByEmail(email);
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurService.findAll();
    }

    @Override
    public void delete(Long id) {
        utilisateurService.delete(id);
    }
    @Override
    public UtilisateurDto changerMotDePasse(ChangerMotDePasseUtilisateurDto dto) {
        return utilisateurService.changerMotDePasse(dto);
    }
}
