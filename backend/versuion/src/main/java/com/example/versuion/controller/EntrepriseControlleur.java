package com.example.versuion.controller;

import com.example.versuion.Dto.EntrepriseDto;
import com.example.versuion.controller.api.EntrepriseApi;
import com.example.versuion.services.ClientService;
import com.example.versuion.services.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class EntrepriseControlleur implements EntrepriseApi {

    EntrepriseService entrepriseService;

    @Autowired
    public EntrepriseControlleur(EntrepriseService entrepriseService){
        this.entrepriseService = entrepriseService;
    }

    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
        return entrepriseService.save(dto);
    }

    @Override
    public EntrepriseDto findById(Long id) {
        return entrepriseService.findById(id);
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseService.findAll();
    }

    @Override
    public void delete(Long id) {
        entrepriseService.delete(id);
    }

    @Override
    public String getMessage() {
        return "Hellow Mohamed Amin Naimi";
    }
}
