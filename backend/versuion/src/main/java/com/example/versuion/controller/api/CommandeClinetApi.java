package com.example.versuion.controller.api;

import com.example.versuion.Dto.ComandeClientDto;
import com.example.versuion.Dto.LigneCommandeClientDto;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.versuion.utiles.Constants.APP_ROOT;
@Api(APP_ROOT + "/commandesclients")
public interface CommandeClinetApi {
    @PostMapping(APP_ROOT + "/commandesclients/create")
    ResponseEntity<ComandeClientDto> save(@RequestBody ComandeClientDto dto);

   /* @PatchMapping(APP_ROOT + "/commandesclients/update/etat/{idCommande}/{etatCommande}")
    ResponseEntity<CommandeClientDto> updateEtatCommande(@PathVariable("idCommande") Integer idCommande, @PathVariable("etatCommande") EtatCommande etatCommande);
    @PatchMapping(APP_ROOT + "/commandesclients/update/quantite/{idCommande}/{idLigneCommande}/{quantite}")
    ResponseEntity<CommandeClientDto> updateQuantiteCommande(@PathVariable("idCommande") Integer idCommande, @PathVariable("idLigneCommande") Integer idLigneCommande, @PathVariable("quantite") BigDecimal quantite);
    @PatchMapping(APP_ROOT + "/commandesclients/update/client/{idCommande}/{idClient}")
    ResponseEntity<CommandeClientDto> updateClient(@PathVariable("idCommande") Integer idCommande, @PathVariable("idClient") Integer idClient);
    @PatchMapping(APP_ROOT + "/commandesclients/update/article/{idCommande}/{idLigneCommande}/{idArticle}")
    ResponseEntity<CommandeClientDto> updateArticle(@PathVariable("idCommande") Integer idCommande,
                                                    @PathVariable("idLigneCommande") Integer idLigneCommande, @PathVariable("idArticle") Integer idArticle);
    @DeleteMapping(APP_ROOT + "/commandesclients/delete/article/{idCommande}/{idLigneCommande}")
    ResponseEntity<CommandeClientDto> deleteArticle(@PathVariable("idCommande") Integer idCommande, @PathVariable("idLigneCommande") Integer idLigneCommande);*/

    @GetMapping(APP_ROOT + "/commandesclients/{idCommandeClient}")
    ResponseEntity<ComandeClientDto> findById(@PathVariable Long idCommandeClient);

    @GetMapping(APP_ROOT + "/commandesclients/filter/{codeCommandeClient}")
    ResponseEntity<ComandeClientDto> findByCode(@PathVariable("codeCommandeClient") String code);

    @GetMapping(APP_ROOT + "/commandesclients/all")
    ResponseEntity<List<ComandeClientDto>> findAll();

   // @GetMapping(APP_ROOT + "/commandesclients/lignesCommande/{idCommande}")
    //ResponseEntity<List<LigneCommandeClientDto>> findAllLignesCommandesClientByCommandeClientId(@PathVariable("idCommande") Integer idCommande);

    @DeleteMapping(APP_ROOT + "/commandesclients/delete/{idCommandeClient}")
    ResponseEntity delete(@PathVariable("idCommandeClient") Long id);
}
