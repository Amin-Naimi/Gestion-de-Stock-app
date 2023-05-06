import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-utilisateurs',
  templateUrl: './utilisateurs.component.html',
  styleUrls: ['./utilisateurs.component.css']
})
export class UtilisateursComponent {

  constructor(private router : Router){}

  nouvelUtilisateur():void{
    this.router.navigate(['/newutilisateur']);
  }

}
