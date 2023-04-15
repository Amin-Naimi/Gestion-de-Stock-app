/*
* "@JsonIgnore". Cela signifie que cette propriété ne sera pas incluse lors de la sérialisation/désérialisation JSON, car elle ne doit pas être considérée comme faisant partie de l'objet CategoryDto à partir de la perspective de la couche d'interface utilisateur ou d'API.

Il est possible que les articles associés à une catégorie soient récupérés à partir d'une autre source de données, ou qu'ils soient gérés séparément de la catégorie elle-même. Dans ce cas, la propriété "articleList" peut être ignorée dans le DTO de catégorie, car elle n'a pas besoin d'être incluse dans la représentation JSON de la catégorie pour les besoins de l'API.

Cependant, si la propriété "articleList" est nécessaire pour le traitement de l'API, elle peut être incluse dans le DTO de catégorie et mappée à l'aide d'une autre méthode, par exemple, une méthode spécifique pour mapper la liste d'articles à un objet DTO distinct.
* */
package com.example.versuion.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Persister;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
/*
@EntityListeners(AuditingEntityListener.class)
L'auditing en Spring Boot est une fonctionnalité qui permet de suivre les modifications apportées à une entité,
telles que l'ajout, la mise à jour ou la suppression. Cette fonctionnalité est utile pour les applications qui
nécessitent un suivi de l'historique des modifications apportées à une entité.
* les annotation d'audites :
*     @CreatedDate
*     @LastModifiedDate
* */
public class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreatedDate
    @Column(name = "creationDate",nullable = false, updatable = false)
    private Instant creationDate;

    @LastModifiedDate
    @Column(name = "lastModifiedDate")
    private Instant lastModifiedDate;

}
