import { Component } from '@angular/core';
import { AdresseDto } from '../Models/AdresseDto';
import { EntrepriseDto } from '../Models/EntrepriseDto';
import { EntrepriseService } from '../services/entreprise.service';
import { UserService } from '../services/user.service';
import { AuthenticationRequest } from '../Models/AuthenticationRequest';
import { Router } from '@angular/router';

@Component({
  selector: 'app-inscire',
  templateUrl: './inscire.component.html',
  styleUrls: ['./inscire.component.css']
})
export class InscireComponent {
  constructor(private entrepriseService: EntrepriseService
    ,private userService : UserService,
    private router:Router){}

  entrepriseDto: EntrepriseDto = {};
  adresse: AdresseDto = {};
  errorsMsg: Array<string> = [];

  inscrire(){
    this.entrepriseDto.adresse = this.adresse;
    this.entrepriseService.sinscrire(this.entrepriseDto).subscribe(
      (response:EntrepriseDto)=>{
        console.log("responce" + response);
      },
      (error)=>{
        this.errorsMsg = error.error.errors;
        console.log("error" + this.errorsMsg);
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
      //this.getUserByEmail(authenticationRequest.login);
      localStorage.setItem('origin', 'inscription');
      this.router.navigate(['changermotdepasse']);
    });
  }

 /* getUserByEmail(email?: string): void {
    this.userService.getUserByEmail(email)
    .subscribe(user => {
      this.userService.setConnectedUser(user);
    });
  }*/
}
