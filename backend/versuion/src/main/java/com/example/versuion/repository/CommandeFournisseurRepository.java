package com.example.versuion.repository;

import com.example.versuion.models.ComandeFournisseur;
import com.example.versuion.models.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CommandeFournisseurRepository extends JpaRepository<ComandeFournisseur,Long> {

    @Query(value = "SELECT * FROM comande_fournisseur WHERE comande_fournisseur.fournisseur_id = :id",nativeQuery = true)
    List<ComandeFournisseur> findAllByFournisseurId(long id);


    Optional<ComandeFournisseur> findByCode(String code);
}
