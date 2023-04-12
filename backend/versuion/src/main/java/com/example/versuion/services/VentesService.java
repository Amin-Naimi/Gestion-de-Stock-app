package com.example.versuion.services;

import com.example.versuion.Dto.VentesDto;

import java.util.List;

public interface VentesService {

    VentesDto save(VentesDto dto);

    VentesDto findById(Long id);

    VentesDto findByCode(String code);

    List<VentesDto> findAll();

    void delete(Long id);
}
