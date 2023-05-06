import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-page-cmd-clt-frs',
  templateUrl: './page-cmd-clt-frs.component.html',
  styleUrls: ['./page-cmd-clt-frs.component.css']
})
export class PageCmdCltFrsComponent {


  constructor(private router: Router){}

  nouvellecommande(): void {
    this.router.navigate(['newcommandeclient']);
  }



}
