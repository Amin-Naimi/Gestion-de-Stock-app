import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ChangerPassword } from 'src/app/Models/ChangerMotDePasse';
import { EnServiceService } from 'src/app/services/en-service.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-changer-mot-depasse',
  templateUrl: './changer-mot-depasse.component.html',
  styleUrls: ['./changer-mot-depasse.component.css']
})
export class ChangerMotDepasseComponent implements OnInit {

  ChangerMotdepasse: ChangerPassword = {};
  ancienMotDePasse = '';


  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private enServiceService: EnServiceService
    , private userService: UserService,
  ) { }
  ngOnInit(): void {
    if (localStorage.getItem('origin') && localStorage.getItem('origin') === 'inscription') {
      this.ancienMotDePasse = 'som3R@nd0mP@$$word';
      //localStorage.removeItem('origin');
    }
  }

  cancel(): void {
    this.router.navigate(['/profile']);
  }

  changerMotDePasseUtilisateur(): void {
    this.ChangerMotdepasse.id = this.userService.getConnectedUser().id;
    this.userService.changerMotDePasse(this.ChangerMotdepasse)
      .subscribe((data: ChangerPassword) => {
        console.log(data);
        this.router.navigate(['profile']);
      },
        (error: any) => {
          console.log(error);
        })
  };
}

