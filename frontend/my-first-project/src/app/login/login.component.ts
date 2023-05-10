import { Component } from '@angular/core';
import { AuthenticationRequest } from '../Models/AuthenticationRequest';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  authenticationRequest: AuthenticationRequest = {};
  errorMessage = '';

  constructor(
    private userService: UserService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }


  login() :void{
    this.userService.login(this.authenticationRequest).subscribe(
      (response: any) => {
        console.log(response);
        this.userService.setAccessToken(response);
        this.getUSerByEmail();
        this.router.navigate(['']);
      },
      (error) => {
        this.errorMessage = 'Login et / ou mot de passe incorrecte';
        console.log(error);
      }
    );
  }

  getUSerByEmail(){
    this.userService.getUserByEmail(this.authenticationRequest.login!).subscribe(
      (response: any) => {
        this.userService.setUtilisateur(response)
      },
      (error: HttpErrorResponse) => {
        console.log(error);
      })
  }


}
