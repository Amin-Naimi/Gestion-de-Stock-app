import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { EnServiceService } from 'src/app/services/en-service.service';

@Component({
  selector: 'app-changer-mot-depasse',
  templateUrl: './changer-mot-depasse.component.html',
  styleUrls: ['./changer-mot-depasse.component.css']
})
export class ChangerMotDepasseComponent implements OnInit {

  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private enServiceService : EnServiceService){}
  ngOnInit(): void {
  }

    cancel(): void {
      this.router.navigate(['/profile']);
    }

    chaine = "";

    getString():void{
      this.enServiceService.testInterceptor().subscribe((responce : any) => {
        console.log(responce);
        this.chaine = responce;
      },
      (error :any) => {
        console.log(error);
      }
      )
    }

}
