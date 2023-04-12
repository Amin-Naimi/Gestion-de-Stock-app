package com.example.versuion.controller;

import com.example.versuion.Dto.ComandeClientDto;
import com.example.versuion.controller.api.CommandeClinetApi;
import com.example.versuion.services.CommandeClinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CommandeClinetControlleur implements CommandeClinetApi {

    private CommandeClinetService commandeClientService;

    @Autowired
    public CommandeClinetControlleur(CommandeClinetService commandeClientService) {
        this.commandeClientService = commandeClientService;
    }

    @Override
    public ResponseEntity<ComandeClientDto> save(ComandeClientDto dto) {
        return ResponseEntity.ok(commandeClientService.save(dto));
    }

    @Override
    public ResponseEntity<ComandeClientDto> findById(Long id) {
        return ResponseEntity.ok(commandeClientService.findById(id));
    }

    @Override
    public ResponseEntity<ComandeClientDto> findByCode(String code) {
        return ResponseEntity.ok(commandeClientService.findByCode(code));
    }

    @Override
    public ResponseEntity<List<ComandeClientDto>> findAll() {
        return ResponseEntity.ok(commandeClientService.findAll());
    }

    @Override
    public ResponseEntity delete(Long id) {
        commandeClientService.delete(id);
        return ResponseEntity.ok().build();
    }
}
