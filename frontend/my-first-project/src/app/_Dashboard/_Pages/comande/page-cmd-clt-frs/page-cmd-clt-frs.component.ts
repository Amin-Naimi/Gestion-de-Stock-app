import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-page-cmd-clt-frs',
  templateUrl: './page-cmd-clt-frs.component.html',
  styleUrls: ['./page-cmd-clt-frs.component.css']
})
export class PageCmdCltFrsComponent implements OnInit {

  origin ="";

  constructor(private router: Router,
    private ActivatedRoute: ActivatedRoute){}

    ngOnInit(): void {
     //Recuperer l'objet origine dans app-routin.ts
      this.ActivatedRoute.data.subscribe((data :any) => {
        this.origin = data.origin;
      })
  }

  nouvellecommande(): void {
    if(this.origin ==="client"){
    this.router.navigate(['newcommandeclient']);
    }
    else if(this.origin ==="forunisseur"){
      this.router.navigate(['/newcommandefournisseur']);
    }
  }



}
