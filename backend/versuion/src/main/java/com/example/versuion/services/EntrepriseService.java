package com.example.versuion.services;

import com.example.versuion.Dto.EntrepriseDto;

import java.util.List;

public interface EntrepriseService {

    EntrepriseDto save(EntrepriseDto dto);

    EntrepriseDto findById(Long id);

    List<EntrepriseDto> findAll();

    void delete(Long id);
}
