package com.example.versuion.services.impl;

import com.example.versuion.Dto.ArticleDto;
import com.example.versuion.Dto.ClientDto;
import com.example.versuion.exception.EntityNotFoundException;
import com.example.versuion.exception.ErrorCodes;
import com.example.versuion.exception.InvalidEntityException;
import com.example.versuion.exception.InvalidOperationException;
import com.example.versuion.models.Article;
import com.example.versuion.models.Client;
import com.example.versuion.models.CommandeClient;
import com.example.versuion.repository.ClientRepository;
import com.example.versuion.repository.CommandeClientRepository;
import com.example.versuion.services.ClientService;
import com.example.versuion.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    private CommandeClientRepository commandeClientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, CommandeClientRepository commandeClientRepository){
        this.clientRepository = clientRepository;
        this.commandeClientRepository = commandeClientRepository;
    }

    @Override
    public ClientDto save(ClientDto dto) {
        List<String> errors = ClientValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Client is not valid {}", dto);
            throw new InvalidEntityException("Le client n'est pas valide", ErrorCodes.CLIENT_NOT_VALID, errors);
        }
        return ClientDto.fromEntity(clientRepository.save(ClientDto.toEntity(dto))
        );
    }

    @Override
    public ClientDto findById(Long id) {
        if (id == null) {
            log.error("Client ID is null");
            return null;
        }
        Optional<Client> client = clientRepository.findById(id);
        ClientDto clientDto = ClientDto.fromEntity(client.get());
        return Optional.of(clientDto).orElseThrow( () ->
                new EntityNotFoundException("Aucun Client avec l' Id"+ id+"dans la base",ErrorCodes.CLIENT_NOT_FOUND));
    }
    /*  ou
    *   public CategoryDto findById(Integer id) {
    if (id == null) {
      log.error("Category ID is null");
      return null;
    }
    return categoryRepository.findById(id)
        .map(CategoryDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException(
            "Aucune category avec l'ID = " + id + " n' ete trouve dans la BDD",
            ErrorCodes.CATEGORY_NOT_FOUND)
        );
  }
    * */


    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList());
    }

        @Override
    public void delete(Long id) {
            if (id == null) {
                log.error("Client ID is null");
                return;
            }
            List<CommandeClient> commandeClients = commandeClientRepository.findAllByClientId(id);
            if (!commandeClients.isEmpty()) {
                throw new InvalidOperationException("Impossible de supprimer un client qui a deja des commande clients",
                        ErrorCodes.CLIENT_ALREADY_IN_USE);
            }
            clientRepository.deleteById(id);
        }
    }

