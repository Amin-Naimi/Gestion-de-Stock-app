package com.example.versuion.Dto;
import com.example.versuion.models.Roles;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import com.example.versuion.models.Utilisateurs;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Builder
@Data
public class RoleDto {

    private Long id;

    private String rolename;

    @JsonIgnore
    private UtilisateurDto utilisateur;


    public static RoleDto fromEntity(Roles roles) {
        if (roles == null) {
            return null;
        }
        return RoleDto.builder()
                .id(roles.getId())
                .rolename(roles.getRolename())
                .build();
    }

    public static Roles toEntity(RoleDto roleDto) {
        if (roleDto == null) {
            return null;
        }
        Roles roles = new Roles();
        roles.setId(roleDto.getId());
        roles.setRolename(roleDto.getRolename());
        roles.setUtilisateur(UtilisateurDto.toEntity(roleDto.getUtilisateur()));
        return roles;
    }
}
