import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthenticationRequest } from '../Models/AuthenticationRequest';
import { AuthenticationResponse } from '../Models/AuthenticationResponse';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  APP_URL = 'http://localhost:8089/gestiondestock';


  constructor(private http :HttpClient, private router: Router){}

  requestHeader = new HttpHeaders(
    { "No-Auth": "True" }
  )

  public login(LoginData: AuthenticationRequest) {
    console.log("Service authenticateResponse :"+LoginData.login);
    console.log("Service authenticateResponse :"+LoginData.password);
    return this.http.post(`${this.APP_URL}/auth/authentification`, LoginData, { headers: this.requestHeader })
  }



}
