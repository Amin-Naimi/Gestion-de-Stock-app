package com.example.versuion.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Roles extends AbstractEntity{

    private String rolename;

    @ManyToOne
    @JoinColumn(name = "idUtilisateur")
    private Utilisateurs utilisateur;

}
