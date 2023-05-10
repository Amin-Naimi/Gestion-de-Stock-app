import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthenticationRequest } from '../Models/AuthenticationRequest';
import { AuthenticationResponse } from '../Models/AuthenticationResponse';
import { AuthenticationService } from './authentication.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Utilisateur } from '../Models/Utilisateure';
import { ChangerPassword } from '../Models/ChangerMotDePasse';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  APP_URL = 'http://localhost:8089/gestiondestock';

  constructor(private authenticationService: AuthenticationService,
    private router: Router,
    private httpClient: HttpClient) { }

  login(authenticationRequest: AuthenticationRequest): Observable<AuthenticationResponse> {
    return this.authenticationService.login(authenticationRequest);
  }
  setAccessToken(authenticationResponse: AuthenticationResponse): void {
    localStorage.setItem('accessToken', JSON.stringify(authenticationResponse));
  }

  isUserLoggedAndAccessTokenValid(): boolean {
    if (localStorage.getItem('accessToken')) {
      return true;
    }
    this.router.navigate(['/login']);
    return false;
  }

  getUserByEmail(email: string): Observable<Utilisateur> {
    return this.httpClient.get<Utilisateur>(`${this.APP_URL}/utilisateurs/find/${email}`)
  }

  setUtilisateur(utilisateur: Utilisateur):void {
    localStorage.setItem("utilisateur", JSON.stringify(utilisateur));
  }

  getConnectedUser():Utilisateur{
    if(localStorage.getItem("utilisateur")){
      return JSON.parse(localStorage.getItem("utilisateur") as string);
    }
    return {};
  }

  changerMotDePasse(ChangerMotDePasseObject: ChangerPassword):Observable<ChangerPassword>{
    return this.httpClient.post<ChangerPassword>(`${this.APP_URL}/utilisateurs/update/password`,ChangerMotDePasseObject);

  }



  /*testInterceptor(): Observable<string> {
    return this.httpClient.get<string>("http://localhost:8089/message");
  }*/
}
