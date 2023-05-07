import { Component } from '@angular/core';
import { AuthenticationRequest } from '../Models/AuthenticationRequest';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';
import { HttpErrorResponse } from '@angular/common/http';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  authenticationRequest: AuthenticationRequest = {};
  errorMessage = '';

  constructor(
    private userService : UserService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }


  login(){
    this.userService.login(this.authenticationRequest).subscribe(
      (response:any)=>{
        console.log(response);
        this.userService.setAccessToken(response);
        this.router.navigate(['']);

      },
      (error)=>{
        this.errorMessage = 'Login et / ou mot de passe incorrecte';
        console.log(error);
      }
    );

  }




}
