package com.example.versuion.services;

import com.example.versuion.Dto.FournisseurDto;

import java.util.List;

public interface FournisseurService {

    FournisseurDto save(FournisseurDto dto);

    FournisseurDto findById(Long id);

    List<FournisseurDto> findAll();

    void delete(Long id);
}
