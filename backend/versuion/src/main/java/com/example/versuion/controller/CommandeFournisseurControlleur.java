package com.example.versuion.controller;

import com.example.versuion.Dto.ComandeFournisseurDto;
import com.example.versuion.controller.api.CommandeFournisseurApi;
import com.example.versuion.services.CommandeFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommandeFournisseurControlleur implements CommandeFournisseurApi {

    private CommandeFournisseurService commandeFournisseurService;

    @Autowired
    public CommandeFournisseurControlleur(CommandeFournisseurService commandeFournisseurService) {
        this.commandeFournisseurService = commandeFournisseurService;
    }

    @Override
    public ComandeFournisseurDto save(ComandeFournisseurDto dto) {
        return commandeFournisseurService.save(dto);
    }

    @Override
    public ComandeFournisseurDto findById(Long id) {
        return commandeFournisseurService.findById(id);
    }

    @Override
    public ComandeFournisseurDto findByCode(String code) {
        return commandeFournisseurService.findByCode(code);
    }

    @Override
    public List<ComandeFournisseurDto> findAll() {
        return commandeFournisseurService.findAll();

    }

    @Override
    public void delete(Long id) {

    }


}
