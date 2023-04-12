package com.example.versuion.repository;

import com.example.versuion.Dto.ComandeClientDto;
import com.example.versuion.models.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CommandeClientRepository extends JpaRepository<CommandeClient,Long> {


    Optional<CommandeClient> findCommandeClientByCode(String code);

    //@Query(value = "SELECT * FROM commande_client WHERE commande_client.id_client = :id",nativeQuery = true)
    List<CommandeClient> findAllByClientId(Long id);
}
