package com.example.versuion.Dto;

import com.example.versuion.models.Adresse;
import com.example.versuion.models.Category;
import com.example.versuion.models.Client;
import com.example.versuion.models.CommandeClient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.OneToMany;
import java.util.List;

@Builder
@Data
public class ClientDto {

    private Long id;

    private String nom;

    private String prenom;

    private AdressDto adresse;

    private String photo;

    private String mail;

    private String numTel;

    private Integer idEntreprise;


    @JsonIgnore
    private List<ComandeClientDto> commandeClientList;

    //Mapping
    public static ClientDto fromEntity(Client client){
        if(client == null){
            return null;
        }
        return ClientDto.builder()
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .adresse(AdressDto.fromEntity(client.getAdresse()))
                .photo(client.getPhoto())
                .mail(client.getMail())
                .numTel(client.getNumTel())
                .idEntreprise(client.getIdEntreprise())
                .build();
    }

    public static Client toEntity(ClientDto clientDto){
        if(clientDto == null){
            return null;
        }
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        client.setAdresse(AdressDto.toEntity(clientDto.getAdresse()));
        client.setPhoto(clientDto.getPhoto());
        client.setMail(clientDto.getMail());
        client.setNumTel(clientDto.getNumTel());
        client.setIdEntreprise(clientDto.getIdEntreprise());

        return client;
    }

}
