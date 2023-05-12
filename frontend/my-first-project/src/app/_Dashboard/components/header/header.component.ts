import { Component, DoCheck, OnInit } from '@angular/core';
import { Utilisateur } from 'src/app/Models/Utilisateure';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements DoCheck {
  connectedUser : Utilisateur = {};
  constructor(private userService: UserService){}
  ngDoCheck(): void {
    console.log("header component initialized")
    this.connectedUser = this.userService.getConnectedUser()  }

  ngOnInit(): void {

   // console.log("connected user : " + this.connectedUser);
  }



}
