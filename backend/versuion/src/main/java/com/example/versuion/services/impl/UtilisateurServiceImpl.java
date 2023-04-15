package com.example.versuion.services.impl;

import com.example.versuion.Dto.UtilisateurDto;
import com.example.versuion.exception.EntityNotFoundException;
import com.example.versuion.exception.ErrorCodes;
import com.example.versuion.exception.InvalidEntityException;
import com.example.versuion.models.Utilisateurs;
import com.example.versuion.repository.UtilisateurRepository;
import com.example.versuion.services.UtilisateurService;
import com.example.versuion.validator.UtilisateursValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {

    private UtilisateurRepository utilisateurRepository;
   // private PasswordEncoder passwordEncoder;

    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
       // this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        List<String> errors = UtilisateursValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Utilisateur is not valid {}", dto);
            throw new InvalidEntityException("L'utilisateur n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
        }
        if(userAlreadyExists(dto.getEmail())) {
            throw new InvalidEntityException("Un autre utilisateur avec le meme email existe deja", ErrorCodes.UTILISATEUR_ALREADY_EXISTS,
                    Collections.singletonList("Un autre utilisateur avec le meme email existe deja dans la BDD"));
        }
        //dto.setMoteDePasse(passwordEncoder.encode(dto.getMoteDePasse()));
        return UtilisateurDto.fromEntity(utilisateurRepository.save(UtilisateurDto.toEntity(dto)));
    }

    private boolean userAlreadyExists(String email) {
        Optional<Utilisateurs> user = utilisateurRepository.findByEmail(email);
        return user.isPresent();
    }

    @Override
    public UtilisateurDto findById(Long id) {
        if (id == null) {
            log.error("Utilisateur ID is null");
            return null;
        }
        return utilisateurRepository.findById(id)
                .map(UtilisateurDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun utilisateur avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.UTILISATEUR_NOT_FOUND)
                );
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurRepository.findAll().stream()
                .map(UtilisateurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            log.error("Utilisateur ID is null");
            return;
        }
        utilisateurRepository.deleteById(id);
    }

    @Override
    public UtilisateurDto findByEmail(String email) {
        return utilisateurRepository.findByEmail(email)
                .map(UtilisateurDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun utilisateur avec l'email = " + email + " n' ete trouve dans la BDD",
                        ErrorCodes.UTILISATEUR_NOT_FOUND)
                );
    }
}
