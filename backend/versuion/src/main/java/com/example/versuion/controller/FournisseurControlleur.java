package com.example.versuion.controller;

import com.example.versuion.Dto.FournisseurDto;
import com.example.versuion.controller.api.FournisseurApi;
import com.example.versuion.services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.awt.event.FocusListener;
import java.util.List;

@RestController
public class FournisseurControlleur implements FournisseurApi {

    FournisseurService fournisseurService;

    @Autowired
    public FournisseurControlleur(FournisseurService fournisseurService){
        this.fournisseurService = fournisseurService;
    }

    @Override
    public FournisseurDto save(FournisseurDto dto) {
        return fournisseurService.save(dto);
    }

    @Override
    public FournisseurDto findById(Long id) {
        return fournisseurService.findById(id);
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurService.findAll();
    }

    @Override
    public void delete(Long id) {
        fournisseurService.delete(id);

    }
}
