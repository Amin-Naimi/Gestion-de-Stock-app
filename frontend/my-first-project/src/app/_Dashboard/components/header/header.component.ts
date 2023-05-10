import { Component, OnInit } from '@angular/core';
import { Utilisateur } from 'src/app/Models/Utilisateure';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  connectedUser : Utilisateur = {};
  constructor(private userService: UserService){}

  ngOnInit(): void {
    this.connectedUser = this.userService.getConnectedUser()
   // console.log("connected user : " + this.connectedUser);
  }



}
