import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-fournisseurs',
  templateUrl: './fournisseurs.component.html',
  styleUrls: ['./fournisseurs.component.css']
})
export class FournisseursComponent {

  constructor(private router: Router,){}

  noveauFournissuer(): void {
    this.router.navigate(['newfournisseur']);
  }

}
