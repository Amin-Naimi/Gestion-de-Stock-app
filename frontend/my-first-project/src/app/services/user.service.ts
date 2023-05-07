import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthenticationRequest } from '../Models/AuthenticationRequest';
import { AuthenticationResponse } from '../Models/AuthenticationResponse';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private authenticationService :AuthenticationService ) { }

  login(authenticationRequest: AuthenticationRequest): Observable<AuthenticationResponse> {
    return this.authenticationService.login(authenticationRequest);
  }
  setAccessToken(authenticationResponse: AuthenticationResponse): void {
    localStorage.setItem('accessToken', JSON.stringify(authenticationResponse));
  }
}
