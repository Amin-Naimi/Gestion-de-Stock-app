import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Category } from '../Models/Category';
import { Observable } from 'rxjs/internal/Observable';
import { UserService } from './user.service';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  APP_URL = 'http://localhost:8089/gestiondestock';

  constructor(private httpClient : HttpClient,
    private userService: UserService) {}

  enregistrerCategory(category : Category):Observable<Category> {
    category.idEntreprise = this.userService.getConnectedUser()?.entreprise?.id;
    return this.httpClient.post<Category>(`${this.APP_URL}/categories/create`,category);
  }

  findAll(): Observable<Category[]>{
    return this.httpClient.get<Category[]>(`${this.APP_URL}/categories/all`);
  }

  findById(idCategory: number): Observable<Category>{
    return this.httpClient.get<Category>(`${this.APP_URL}/categories/${idCategory}`)
  }

  updateCategory(id: number, category : Category): Observable<Category>{
    category.idEntreprise = this.userService.getConnectedUser()?.entreprise?.id;
    return this.httpClient.put<Category>(`${this.APP_URL}/categories/update/${id}`,category);

  }

  deleteCategory(idCategory: number): Observable<void>{
    return this.httpClient.delete<void>(`${this.APP_URL}/categories/delete/${idCategory}`);
  }
}
