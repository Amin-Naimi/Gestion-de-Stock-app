package com.example.versuion.controller.api;

import com.example.versuion.Dto.ArticleDto;
import com.example.versuion.Dto.LigneCommandeClientDto;
import com.example.versuion.Dto.LigneCommandeFournisseurDto;
import com.example.versuion.Dto.LigneVentDto;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.versuion.utiles.Constants.APP_ROOT;

@Api(APP_ROOT + "/articles")
public interface ArticleApi {

    @PostMapping(value = APP_ROOT + "/articles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un article", notes = "Cette methode permet d'enregistrer ou modifier un article", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet article cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet article n'est pas valide")
    })
    ArticleDto save(@RequestBody ArticleDto articleDto);
    //RequestBody : faire la transformation de l'objet de format json vers "ArticleDto"

    @GetMapping(value = APP_ROOT + "/articles/find/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un article par ID", notes = "Cette methode permet de chercher un article par son ID", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'article a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun article n'existe dans la BDD avec l'ID fourni")
    })
    ArticleDto findById(@PathVariable("idArticle") Long articleId);

    @GetMapping(value = APP_ROOT + "/articles/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un article par CODE", notes = "Cette methode permet de chercher un article par son CODE", response =
            ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'article a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun article n'existe dans la BDD avec le CODE fourni")
    })
    ArticleDto findByCodeArticle(@PathVariable("codeArticle") String codeArticle);

    @GetMapping(value = APP_ROOT + "/articles/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des articles", notes = "Cette methode permet de chercher et renvoyer la liste des articles qui existent "
            + "dans la BDD", responseContainer = "List<ArticleDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des article / Une liste vide")
    })
    List<ArticleDto> findAll();

    @GetMapping(value = APP_ROOT + "/articles/historique/vente/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<LigneVentDto> findHistoriqueVentes(@PathVariable("idArticle") Long idArticle);

    @GetMapping(value = APP_ROOT + "/articles/historique/commandeclient/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<LigneCommandeClientDto> findHistoriaueCommandeClient(@PathVariable("idArticle") Long idArticle);

    @GetMapping(value = APP_ROOT + "/articles/historique/commandefournisseur/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(@PathVariable("idArticle") Long idArticle);

    @GetMapping(value = APP_ROOT + "/articles/filter/category/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> findAllArticleByIdCategory(@PathVariable("idCategory") Long idCategory);


    @DeleteMapping(value = APP_ROOT + "/articles/delete/{idArticle}")
    @ApiOperation(value = "Supprimer un article", notes = "Cette methode permet de supprimer un article par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'article a ete supprime")
    })
    void delete (@PathVariable("idArticle") Long articleId);
}
