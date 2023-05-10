import { Component } from '@angular/core';
import { AdresseDto } from '../Models/AdresseDto';
import { EntrepriseDto } from '../Models/EntrepriseDto';
import { UserService } from '../services/user.service';
import { AuthenticationRequest } from '../Models/AuthenticationRequest';
import { Router } from '@angular/router';
import { EnServiceService } from '../services/en-service.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-inscire',
  templateUrl: './inscire.component.html',
  styleUrls: ['./inscire.component.css']
})
export class InscireComponent {
  constructor(private entrepriseService: EnServiceService
    ,private userService : UserService,
    private router:Router){}

  entrepriseDto: EntrepriseDto = {};
  adresse: AdresseDto = {};
  errorsMsg: Array<string> = [];
  authenticationRequest: AuthenticationRequest = {};


  inscrire():void{
    this.entrepriseDto.adresse = this.adresse;
    console.log(this.entrepriseDto);
    this.entrepriseService.save(this.entrepriseDto).subscribe(
      (response:EntrepriseDto)=>{
        console.log("responce" + response);
        this.errorsMsg = [];
        this.connectEntreprise();

      },
      (error)=>{
        console.log(error);
        this.errorsMsg = error.error.errors;
        console.log("error " + this.errorsMsg);
      }
    )
  }

  connectEntreprise(): void {
    const authenticationRequest: AuthenticationRequest = {
      login: this.entrepriseDto.email,
      password: 'som3R@nd0mP@$$word'
    };
    this.userService.login(authenticationRequest)
    .subscribe(response => {
      this.userService.setAccessToken(response);
      this.getUserByEmail(authenticationRequest.login!);
      console.log("Sette dans le locale storage");
      localStorage.setItem('origin', 'inscription');
      this.router.navigate(['/changermotdepasse']);
      console.log("localStorage length : " + localStorage.length)
    });
  }


  getUserByEmail(email: string): void{
    this.userService.getUserByEmail(email).subscribe(
      (response: any) => {
        this.userService.setUtilisateur(response)
      },
      (error: HttpErrorResponse) => {
        console.log(error);
      })
  }
}
