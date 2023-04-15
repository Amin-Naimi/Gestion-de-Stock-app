package com.example.versuion.repository;

import com.example.versuion.models.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateurs,Long> {
    // JPQL query
    //@Query(value = "select utilisateurs from utilisateurs where utilisateurs.email = :email",nativeQuery = true)
    //Optional<Utilisateurs> findUtilisateurByEmail(@Param("email") String email);

    Optional<Utilisateurs> findByEmail(String email);
}
