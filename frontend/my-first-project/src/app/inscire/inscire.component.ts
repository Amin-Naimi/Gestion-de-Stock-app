import { Component } from '@angular/core';
import { AdresseDto } from '../Models/AdresseDto';
import { EntrepriseDto } from '../Models/EntrepriseDto';
import { EntrepriseService } from '../services/entreprise.service';

@Component({
  selector: 'app-inscire',
  templateUrl: './inscire.component.html',
  styleUrls: ['./inscire.component.css']
})
export class InscireComponent {
  constructor(private entrepriseService: EntrepriseService){}

  entrepriseDto: EntrepriseDto = {};
  adresse: AdresseDto = {};
  errorsMsg: Array<string> = [];

  inscrire(){
    this.entrepriseDto.adresse = this.adresse;
    this.entrepriseService.sinscrire(this.entrepriseDto).subscribe(
      (response:any)=>{
        console.log(response);
      },
      (error)=>{
        this.errorsMsg = error.error.errors;
        console.log(this.errorsMsg);
      }
    )

  }
}
