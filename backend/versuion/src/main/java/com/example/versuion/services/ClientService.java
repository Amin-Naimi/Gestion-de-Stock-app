package com.example.versuion.services;

import com.example.versuion.Dto.ClientDto;

import java.util.List;

public interface ClientService {

    ClientDto save(ClientDto dto);

    ClientDto findById(Long id);

    List<ClientDto> findAll();

    void delete(Long id);

}
