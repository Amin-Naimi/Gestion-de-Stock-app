package com.example.versuion.services.impl;

import com.example.versuion.Dto.*;
import com.example.versuion.exception.EntityNotFoundException;
import com.example.versuion.exception.ErrorCodes;
import com.example.versuion.exception.InvalidEntityException;
import com.example.versuion.exception.InvalidOperationException;
import com.example.versuion.models.*;
import com.example.versuion.repository.ArticleRepository;
import com.example.versuion.repository.ClientRepository;
import com.example.versuion.repository.CommandeClientRepository;
import com.example.versuion.repository.LigneCommandeClientRepository;
import com.example.versuion.services.ClientService;
import com.example.versuion.services.CommandeClinetService;
import com.example.versuion.services.MvtStkService;
import com.example.versuion.validator.ArticleValidator;
import com.example.versuion.validator.CommandeClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.Instant;
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
    private MvtStkService mvtStkService;

    @Autowired
    public CommandeClinetServiceImpl(CommandeClientRepository commandeClientRepository,
                                     ClientRepository clientRepository,
                                     ArticleRepository articleRepository,
                                     LigneCommandeClientRepository ligneCommandeClientRepository,
                                     MvtStkService mvtStkService) {
        this.commandeClientRepository = commandeClientRepository;
        this.clientRepository = clientRepository;
        this.articleRepository = articleRepository;
        this.ligneCommandeClientRepository = ligneCommandeClientRepository;
        this.mvtStkService = mvtStkService;
    }

    @Override
    public ComandeClientDto save(ComandeClientDto dto) {
        List<String> errors = CommandeClientValidator.validate(dto);

        if (!errors.isEmpty()) {
            log.error("Commande client n'est pas valide");
            throw new InvalidEntityException("La commande client n'est pas valide", ErrorCodes.COMMANDE_CLIENT_NOT_VALID, errors);
        }

        if (dto.getId() != null && dto.isCommandeLivree()) {
            throw new InvalidOperationException("Impossible de modifier la commande lorsqu'elle est livree", ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
        }

        /**Verifer l'existance du client dans la base**/
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
                } else {
                    articleErrors.add("Impossible d'enregister une commande avec un aticle NULL");
                }
            });
        }

        if (!articleErrors.isEmpty()) {
            log.warn("");
            throw new InvalidEntityException("Article n'existe pas dans la BD", ErrorCodes.ARTICLE_NOT_FOUND, articleErrors);
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
        List<LigneComandeClient> ligneCommandeClients = ligneCommandeClientRepository.findAllByCommandeClientId(id);
        if (!ligneCommandeClients.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer une commande client deja utilisee",
                    ErrorCodes.COMMANDE_CLIENT_ALREADY_IN_USE);
        }
        commandeClientRepository.deleteById(id);
    }

    @Override
    public ComandeClientDto updateEtatCommande(Long idCommande, EtatCommande etatCommande) {
        checkIdCommande(idCommande);

        if (!StringUtils.hasLength(String.valueOf(etatCommande))) {
            log.error("L'etat de la Commande client is NULL");
            throw new InvalidOperationException("Impossible de modifier l'état du commande avec un etat null", ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
        }

        ComandeClientDto comandeClientDto = checkEtatCommande(idCommande);
        comandeClientDto.setEtatCommande(etatCommande);

        CommandeClient commandeClientSaved = commandeClientRepository.save(ComandeClientDto.toEntity(comandeClientDto));
        if(comandeClientDto.isCommandeLivree()) {
            updateMvtStk(idCommande);
        }
        return ComandeClientDto.fromEntity(commandeClientSaved);
    }

    @Override
    public ComandeClientDto updateQuantiteCommande(Long idCommande, Long idLigneCommande, BigDecimal quantite) {
        checkIdCommande(idCommande);
        checkIdLigneCommande(idLigneCommande);

        if (quantite == null || quantite.compareTo(BigDecimal.ZERO) == 0) {
            log.error("la quantité de la ligne commande is NULL");
            throw new InvalidOperationException("Impossible de modifier l'etat de la commande avec une quantite null ou ZERO",
                    ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
        }

        ComandeClientDto comandeClientDto = checkEtatCommande(idCommande);
        Optional<LigneComandeClient> ligneCommandeClientOptional = ligneCommandeClientRepository.findById(idLigneCommande);

        if(ligneCommandeClientOptional.isEmpty()){
            throw new EntityNotFoundException(" Aucune ligne de commande client avec l'id " + idLigneCommande + " a été trouver dans la BD",ErrorCodes.COMMANDE_CLIENT_NOT_FOUND);
        }
        LigneComandeClient ligneComandeClient = ligneCommandeClientOptional.get();
        ligneComandeClient.setQuantite(quantite);
        LigneComandeClient savedLigne= ligneCommandeClientRepository.save(ligneComandeClient);
        return comandeClientDto;

    }

    @Override
    public ComandeClientDto updateClient(Long idCommande, Long idClient) {
       checkIdCommande(idCommande);

        if (idClient == null) {
            log.error("client ID is NULL");
            throw new InvalidOperationException("Impossible de modifier l'etat de la commande avec un ID du client null",
                    ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
        }
        ComandeClientDto comandeClientDto = checkEtatCommande(idCommande);

        Optional<Client> optionalClient=clientRepository.findById(idClient);
        if (optionalClient.isEmpty()) {
            throw new EntityNotFoundException(
                    "Aucun client n'a ete trouve avec l'ID " + idClient, ErrorCodes.CLIENT_NOT_FOUND);
        }
        comandeClientDto.setClient(ClientDto.fromEntity(optionalClient.get()));

        return ComandeClientDto.fromEntity(
                commandeClientRepository.save(ComandeClientDto.toEntity(comandeClientDto))
        );
    }

    @Override
    public ComandeClientDto updateArticle(Long idCommande, Long idLigneCommande, Long newIdArticle) {
        checkIdCommande(idCommande);
        checkIdLigneCommande(idLigneCommande);
        checkIdArticle(newIdArticle, "noveau");
        ComandeClientDto comandeClientDto = checkEtatCommande(idCommande);

        Optional<LigneComandeClient> ligneCommandeClientOptional = findLigneCommandeClient(idLigneCommande);

        Optional<Article> articleOptional = articleRepository.findById(newIdArticle);
        if (articleOptional.isEmpty()) {
            throw new EntityNotFoundException(
                    "Aucune article n'a ete trouve avec l'ID " + newIdArticle, ErrorCodes.ARTICLE_NOT_FOUND);
        }

        List<String> errors = ArticleValidator.validate(ArticleDto.fromEntity(articleOptional.get()));
        if (!errors.isEmpty()) {
            throw new InvalidEntityException("Article invalid", ErrorCodes.ARTICLE_NOT_VALID, errors);
        }

        LigneComandeClient ligneCommandeClientToSaved = ligneCommandeClientOptional.get();
        ligneCommandeClientToSaved.setArticle(articleOptional.get());
        ligneCommandeClientRepository.save(ligneCommandeClientToSaved);

        return comandeClientDto;
    }

    @Override
    public ComandeClientDto deleteArticle(Long idCommande, Long idLigneCommande) {
        checkIdCommande(idCommande);
        checkIdLigneCommande(idLigneCommande);

        ComandeClientDto commandeClient = checkEtatCommande(idCommande);

        findLigneCommandeClient(idLigneCommande);
        ligneCommandeClientRepository.deleteById(idLigneCommande);

        return commandeClient;
    }

    @Override
    public List<LigneCommandeClientDto> findAllLignesCommandesClientByCommandeClientId(Long idCommande) {
        return ligneCommandeClientRepository.findAllByCommandeClientId(idCommande).stream()
                .map(LigneCommandeClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    private void checkIdCommande(Long idCommande) {
        if (idCommande == null) {
            log.error("Commande client ID is NULL");
            throw new InvalidOperationException("Impossible de modifier l'etat de la commande avec un ID null",
                    ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
        }
    }
    private void checkIdLigneCommande(Long idLigneCommande) {
        if (idLigneCommande == null) {
            log.error("L'ID de la ligne commande is NULL");
            throw new InvalidOperationException("Impossible de modifier l'etat de la commande avec une ligne de commande null",
                    ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
        }
    }
    private void checkIdArticle(Long idArticle, String msg) {
        if (idArticle == null) {
            log.error("L'ID de " + msg + " is NULL");
            throw new InvalidOperationException("Impossible de modifier l'etat de la commande avec un " + msg + " ID article null",
                    ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
        }
    }

    private ComandeClientDto checkEtatCommande(Long idCommande) {
        ComandeClientDto commandeClient = findById(idCommande);
        if (commandeClient.isCommandeLivree()) {
            throw new InvalidOperationException("Impossible de modifier la commande lorsqu'elle est livree", ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
        }
        return commandeClient;
    }

    private Optional<LigneComandeClient> findLigneCommandeClient(Long idLigneCommande) {
        Optional<LigneComandeClient> ligneCommandeClientOptional = ligneCommandeClientRepository.findById(idLigneCommande);
        if (ligneCommandeClientOptional.isEmpty()) {
            throw new EntityNotFoundException(
                    "Aucune ligne commande client n'a ete trouve avec l'ID " + idLigneCommande, ErrorCodes.COMMANDE_CLIENT_NOT_FOUND);
        }
        return ligneCommandeClientOptional;
    }

    private void updateMvtStk(Long idCommande) {
        List<LigneComandeClient> ligneCommandeClients = ligneCommandeClientRepository.findAllByCommandeClientId(idCommande);
        ligneCommandeClients.forEach(lig -> {
            effectuerSortie(lig);
        });
    }

    private void effectuerSortie(LigneComandeClient lig) {
        MvtStkDto mvtStkDto = MvtStkDto.builder()
                .article(ArticleDto.fromEntity(lig.getArticle()))
                .dateMvt(Instant.now())
                .typeMvt(TypeMvtStk.SORTIE)
                .sourceMvt(SourceMvtStk.COMMANDE_CLIENT)
                .quantite(lig.getQuantite())
                .idEntreprise(lig.getIdEntreprise())
                .build();
        mvtStkService.sortieStock(mvtStkDto);
    }


}
