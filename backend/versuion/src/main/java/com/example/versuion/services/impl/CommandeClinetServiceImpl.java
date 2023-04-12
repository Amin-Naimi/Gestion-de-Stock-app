package com.example.versuion.services.impl;

import com.example.versuion.Dto.ComandeClientDto;
import com.example.versuion.Dto.LigneCommandeClientDto;
import com.example.versuion.exception.EntityNotFoundException;
import com.example.versuion.exception.ErrorCodes;
import com.example.versuion.exception.InvalidEntityException;
import com.example.versuion.models.Article;
import com.example.versuion.models.Client;
import com.example.versuion.models.CommandeClient;
import com.example.versuion.models.LigneComandeClient;
import com.example.versuion.repository.ArticleRepository;
import com.example.versuion.repository.ClientRepository;
import com.example.versuion.repository.CommandeClientRepository;
import com.example.versuion.repository.LigneCommandeClientRepository;
import com.example.versuion.services.ClientService;
import com.example.versuion.services.CommandeClinetService;
import com.example.versuion.validator.CommandeClientValidator;
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
public class CommandeClinetServiceImpl implements CommandeClinetService {

    private CommandeClientRepository commandeClientRepository;
    private ClientRepository clientRepository;
    private ArticleRepository articleRepository;
    private LigneCommandeClientRepository ligneCommandeClientRepository;

    @Autowired
    public CommandeClinetServiceImpl(CommandeClientRepository commandeClientRepository,
                                     ClientRepository clientRepository,
                                     ArticleRepository articleRepository,
                                     LigneCommandeClientRepository ligneCommandeClientRepository){
        this.commandeClientRepository  = commandeClientRepository;
        this.clientRepository = clientRepository;
        this.articleRepository = articleRepository;
        this.ligneCommandeClientRepository = ligneCommandeClientRepository;
    }

    @Override
    public ComandeClientDto save(ComandeClientDto dto) {
        List<String> errors = CommandeClientValidator.validate(dto);

        if (!errors.isEmpty()) {
            log.error("Commande client n'est pas valide");
            throw new InvalidEntityException("La commande client n'est pas valide", ErrorCodes.COMMANDE_CLIENT_NOT_VALID, errors);
        }

        /**Verifer l'existance du client dnas la base**/

        Optional<Client> client = clientRepository.findById(dto.getClient().getId());
        if (client.isEmpty()) {
            log.warn("Client with ID {} was not found in the DB", dto.getClient().getId());
            throw new EntityNotFoundException("Aucun client avec l'ID" + dto.getClient().getId() + " n'a ete trouve dans la BDD",
                    ErrorCodes.CLIENT_NOT_FOUND);
        }

        List<String> articleErrors = new ArrayList<>();

        /*Verification sur les articles*/
        if (dto.getLigneComandeClientList() != null) {
            dto.getLigneComandeClientList().forEach(ligCmdClt -> {

                if (ligCmdClt.getArticle() != null) {
                    Optional<Article> article = articleRepository.findById(ligCmdClt.getArticle().getId());
                    if (article.isEmpty()) {
                        articleErrors.add("L'article avec l'ID " + ligCmdClt.getArticle().getId() + " n'existe pas");
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

        CommandeClient savedCmdClt = commandeClientRepository.save(ComandeClientDto.toEntity(dto));
        if (dto.getLigneComandeClientList() != null) {
            dto.getLigneComandeClientList().forEach(ligCmdClt -> {
                LigneComandeClient ligneCommandeClient = LigneCommandeClientDto.toEntity(ligCmdClt);
                ligneCommandeClient.setCommandeClient(savedCmdClt);
                ligneCommandeClientRepository.save(ligneCommandeClient);
            });
        }
        return ComandeClientDto.fromEntity(savedCmdClt);
    }

    @Override
    public ComandeClientDto findById(Long id) {
        if (id == null) {
            log.error("Commande client ID is NULL");
            return null;
        }
        return commandeClientRepository.findById(id)
                .map(ComandeClientDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune commande client n'a ete trouve avec l'ID " + id, ErrorCodes.COMMANDE_CLIENT_NOT_FOUND
                ));
    }

    @Override
    public ComandeClientDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Commande client CODE is NULL");
            return null;
        }
        return commandeClientRepository.findCommandeClientByCode(code)
                .map(ComandeClientDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune commande client n'a ete trouve avec le CODE " + code, ErrorCodes.COMMANDE_CLIENT_NOT_FOUND
                ));
    }

    @Override
    public List<ComandeClientDto> findAll() {
        return commandeClientRepository.findAll().stream()
                .map(ComandeClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            log.error("Commande client ID is NULL");
            return;
        }
        commandeClientRepository.deleteById(id);
    }

}
