package com.example.versuion.services.impl;

import com.example.versuion.Dto.ComandeClientDto;
import com.example.versuion.Dto.ComandeFournisseurDto;
import com.example.versuion.Dto.LigneCommandeClientDto;
import com.example.versuion.Dto.LigneCommandeFournisseurDto;
import com.example.versuion.exception.EntityNotFoundException;
import com.example.versuion.exception.ErrorCodes;
import com.example.versuion.exception.InvalidEntityException;
import com.example.versuion.models.*;
import com.example.versuion.repository.*;
import com.example.versuion.services.CommandeFournisseurService;
import com.example.versuion.validator.CommandeClientValidator;
import com.example.versuion.validator.CommandeFournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandeFournisseurServiceImpl implements CommandeFournisseurService {

    private CommandeFournisseurRepository commandeFournisseurRepository;
    private FournisseurRepository fournisseurRepository;
    private ArticleRepository articleRepository;
    private LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository;

    @Autowired
    public CommandeFournisseurServiceImpl(CommandeFournisseurRepository commandeFournisseurRepository,
                                          FournisseurRepository fournisseurRepository,
                                          ArticleRepository articleRepository,
                                          LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository){
        this.commandeFournisseurRepository  = commandeFournisseurRepository;
        this.fournisseurRepository = fournisseurRepository;
        this.articleRepository = articleRepository;
        this.ligneCommandeFournisseurRepository = ligneCommandeFournisseurRepository;
    }

    @Override
    public ComandeFournisseurDto save(ComandeFournisseurDto dto) {
        List<String> errors = CommandeFournisseurValidator.validate(dto);

        if (!errors.isEmpty()) {
            log.error("Commande fournisseur n'est pas valide");
            throw new InvalidEntityException("La commande fournisseur n'est pas valide", ErrorCodes.COMMANDE_FOURNISSEUR_NOT_VALID, errors);
        }

        /**Verifer l'existance du fournisseur dnas la base**/

        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(dto.getFournisseur().getId());
        if (fournisseur.isEmpty()) {
            log.warn("Fournisseur with ID {} was not found in the DB", dto.getFournisseur().getId());
            throw new EntityNotFoundException("Aucun fournisseur avec l'ID" + dto.getFournisseur().getId() + " n'a ete trouve dans la BDD",
                    ErrorCodes.FOURNISSEUR_NOT_FOUND);
        }

        List<String> articleErrors = new ArrayList<>();

        /*Verification sur les articles*/
        if (dto.getLigneComandeFournisseurList() != null) {
            dto.getLigneComandeFournisseurList().forEach(ligCmdFrs -> {

                if (ligCmdFrs.getArticle() != null) {
                    Optional<Article> article = articleRepository.findById(ligCmdFrs.getArticle().getId());
                    if (article.isEmpty()) {
                        articleErrors.add("L'article avec l'ID " + ligCmdFrs.getArticle().getId() + " n'existe pas");
                    }
                }
                else {
                    articleErrors.add("Impossible d'enregister une commande avec un aticle NULL");
                }
            });
        }

        if (!articleErrors.isEmpty()) {
            log.warn("");
            throw new InvalidEntityException("Article n'existe pas dans la BDD", ErrorCodes.ARTICLE_NOT_FOUND, articleErrors);
        }

        ComandeFournisseur savedCmdFrs = commandeFournisseurRepository.save(ComandeFournisseurDto.toEntity(dto));
        if (dto.getLigneComandeFournisseurList() != null) {
            dto.getLigneComandeFournisseurList().forEach(ligCmdFrs -> {
                LigneComandeFournisseur ligneComandeFournisseur = LigneCommandeFournisseurDto.toEntity(ligCmdFrs);
                ligneComandeFournisseur.setCommandefournisseur(savedCmdFrs);
                ligneCommandeFournisseurRepository.save(ligneComandeFournisseur);
            });
        }
        return ComandeFournisseurDto.fromEntity(savedCmdFrs);
    }

    @Override
    public ComandeFournisseurDto findById(Long id) {
        if (id == null) {
            log.error("Commande fournisseur ID is NULL");
            return null;
        }
        return commandeFournisseurRepository.findById(id)
                .map(ComandeFournisseurDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune commande fournisseur n'a ete trouve avec l'ID " + id, ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND
                ));
    }

    @Override
    public ComandeFournisseurDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Commande fournisseur CODE is NULL");
            return null;
        }
        return commandeFournisseurRepository.findByCode(code)
                .map(ComandeFournisseurDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune commande fournisseur n'a ete trouve avec le CODE " + code, ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND
                ));
    }

    @Override
    public List<ComandeFournisseurDto> findAll() {
        return commandeFournisseurRepository.findAll().stream()
                .map(ComandeFournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            log.error("Commande fournisseur ID is NULL");
            return;
        }
        commandeFournisseurRepository.deleteById(id);
    }
}
