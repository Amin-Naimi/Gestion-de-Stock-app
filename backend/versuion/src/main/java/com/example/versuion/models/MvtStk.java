package com.example.versuion.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class MvtStk extends AbstractEntity{

    private Instant dateMvt;

    private BigDecimal quantite;

     @ManyToOne
    @JoinColumn(name = "idearticle")
    private Article article;

    @Enumerated(EnumType.STRING)
    private TypeMvtStk typeMvt;

    @Column(name = "sourcemvt")
    @Enumerated(EnumType.STRING)
    private SourceMvtStk sourceMvt;

    @Column(name = "identreprise")
    private Integer idEntreprise;

}
