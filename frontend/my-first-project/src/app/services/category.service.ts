import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Category } from '../Models/Category';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  APP_URL = 'http://localhost:8089/gestiondestock';

  constructor(private httpClient : HttpClient) {}

  enregistrerCategory(category : Category):Observable<Category> {
    return this.httpClient.post<Category>(`${this.APP_URL}/categories/create`,category);

  }
}
