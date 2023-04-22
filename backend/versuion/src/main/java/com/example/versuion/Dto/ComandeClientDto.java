package com.example.versuion.Dto;

import com.example.versuion.models.Client;
import com.example.versuion.models.CommandeClient;
import com.example.versuion.models.EtatCommande;
import com.example.versuion.models.LigneComandeClient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.List;

@Builder
@Data
public class ComandeClientDto {

    private Long id;

    private String code;

    private Instant dateComande;

    private EtatCommande etatCommande;

    private ClientDto client;

    private Integer idEntreprise;

    @JsonIgnore
    private List<LigneCommandeClientDto> ligneComandeClientList;

    //Mapping
    public static ComandeClientDto fromEntity(CommandeClient commandeClient){
        if(commandeClient == null){
            return null;
        }
        return ComandeClientDto.builder()
                .id(commandeClient.getId())
                .code(commandeClient.getCode())
                .dateComande(commandeClient.getDateComande())
                .etatCommande(commandeClient.getEtatCommande())
                .client(ClientDto.fromEntity(commandeClient.getClient()))
                .idEntreprise(commandeClient.getIdEntreprise())
                .build();
    }

    public static CommandeClient toEntity(ComandeClientDto comandeClientDto){
        if(comandeClientDto == null){
            return null;
        }
        CommandeClient commandeClient = new CommandeClient();
        commandeClient.setId(comandeClientDto.getId());
        commandeClient.setCode(comandeClientDto.getCode());
        commandeClient.setDateComande(comandeClientDto.getDateComande());
        commandeClient.setClient(ClientDto.toEntity(comandeClientDto.getClient()));
        commandeClient.setEtatCommande(comandeClientDto.getEtatCommande());
        commandeClient.setIdEntreprise(comandeClientDto.getIdEntreprise());

        return commandeClient;
    }

    public boolean isCommandeLivree() {
        return EtatCommande.LIVREE.equals(this.etatCommande);
    }

}
