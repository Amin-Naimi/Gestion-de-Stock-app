import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EntrepriseDto } from '../Models/EntrepriseDto';

@Injectable({
  providedIn: 'root'
})
export class EnServiceService {

  APP_URL = 'http://localhost:8089/gestiondestock';

  requestHeader = new HttpHeaders(
    { "No-Auth": "True" }
  )

  private entrepriseEndpoint = this.APP_URL+'/entreprises'; // remplacer par votre endpoint backend

  constructor(private http: HttpClient) { }

  save(entreprise: EntrepriseDto): Observable<EntrepriseDto> {
    return this.http.post<EntrepriseDto>(`${this.entrepriseEndpoint}/create`, entreprise, { headers: this.requestHeader });
  }

  testInterceptor():Observable<string>{
    return this.http.get<string>("http://localhost:8089/message");
  }
}
