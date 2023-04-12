package com.example.versuion.models;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class Adresse implements Serializable {

    private String addresse1;

    private String addresse2;

    private String Ville;

    private String codePostale;

    private String pays;




}
