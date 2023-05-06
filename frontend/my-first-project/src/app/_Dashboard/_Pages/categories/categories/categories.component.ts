import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent {

  constructor(private router: Router){}

  nouvelleCategorie():void{
    this.router.navigate(['newcategorie']);
  }

}
