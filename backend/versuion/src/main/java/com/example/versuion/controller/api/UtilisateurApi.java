package com.example.versuion.controller.api;

import com.example.versuion.Dto.ChangerMotDePasseUtilisateurDto;
import com.example.versuion.Dto.UtilisateurDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.versuion.utiles.Constants.UTILISATEUR_ENDPOINT;
@Api(UTILISATEUR_ENDPOINT)
public interface UtilisateurApi {

    @PostMapping(UTILISATEUR_ENDPOINT + "/create")
    String save(@RequestBody UtilisateurDto dto);

    @GetMapping(UTILISATEUR_ENDPOINT + "/{idUtilisateur}")
    UtilisateurDto findById(@PathVariable("idUtilisateur") Long id);

    @GetMapping(UTILISATEUR_ENDPOINT + "/find/{email}")
    UtilisateurDto findByEmail(@PathVariable("email") String email);

    @GetMapping(UTILISATEUR_ENDPOINT + "/all")
    List<UtilisateurDto> findAll();

    @DeleteMapping(UTILISATEUR_ENDPOINT + "/delete/{idUtilisateur}")
    void delete(@PathVariable("idUtilisateur") Long id);

    @PostMapping(UTILISATEUR_ENDPOINT + "/update/password")
    UtilisateurDto changerMotDePasse(@RequestBody ChangerMotDePasseUtilisateurDto dto);

}
