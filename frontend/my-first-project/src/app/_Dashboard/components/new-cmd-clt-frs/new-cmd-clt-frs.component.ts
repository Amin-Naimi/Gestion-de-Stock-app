import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-new-cmd-clt-frs',
  templateUrl: './new-cmd-clt-frs.component.html',
  styleUrls: ['./new-cmd-clt-frs.component.css']
})
export class NewCmdCltFrsComponent implements OnInit {

  origin = "";
  constructor(private activatedRoute : ActivatedRoute,){}
  ngOnInit(): void {
    //Recuperer l'objet origine dans app-routin.ts
      this.activatedRoute.data.subscribe((data :any) => {
        this.origin = data.origin;
      })
  }


}
