package com.example.versuion.repository;

import com.example.versuion.models.LigneComandeClient;
import com.example.versuion.models.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VentesRepository extends JpaRepository<Ventes,Long> {

    Optional<Ventes> findByCode(String aLong);


}
