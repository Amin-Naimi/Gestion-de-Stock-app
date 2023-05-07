import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-new-clt-frs',
  templateUrl: './new-clt-frs.component.html',
  styleUrls: ['./new-clt-frs.component.css']
})
export class NewCltFrsComponent implements OnInit {

  origin = "";

  constructor(private activatedRoute : ActivatedRoute,
    private router: Router){}

  ngOnInit(): void {
    //Recuperer l'objet origine dans app-routin.ts
      this.activatedRoute.data.subscribe((data :any) => {
        this.origin = data.origin;
      })
  }

  cancelClick():void{
    if(this.origin ==="client"){
      this.router.navigate(['/client']);
    }
    else if(this.origin ==="forunisseur"){
      this.router.navigate(['/fournisseurs']);
    }

  }





}


