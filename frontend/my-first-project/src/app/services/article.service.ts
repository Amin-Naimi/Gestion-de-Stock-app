import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from './user.service';
import { CategoryService } from './category.service';
import { HttpClient } from '@angular/common/http';
import { Article } from '../Models/Article';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  APP_URL = 'http://localhost:8089/gestiondestock/articles';

  constructor(private router : Router,
    private userService: UserService,
    private httpClient: HttpClient) {}

    enregisterArticle(article: Article):Observable<Article> {
      article.idEntreprise = this.userService.getConnectedUser().entreprise?.id;
      return this.httpClient.post<Article>(`${this.APP_URL}/create`,article);
    }

    getAllArticles():Observable<Article[]> {
      return this.httpClient.get<Article[]>(`${this.APP_URL}/all`);
    }

    findArticleById(idArticle: number):Observable<Article> {
      return this.httpClient.get<Article>(`${this.APP_URL}/find/${idArticle}`);
    }

    deleteArticle(idArticle: number):Observable<void>{
      return this.httpClient.delete<void>(`${this.APP_URL}/delete/${idArticle}`);
    }
/*
    enregisterArticle(article: Article):Observable<Article> {
      return this.httpClient.post<Article>(`${this.APP_URL}/`,article);
    }*/
}


