import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-new-utilisteur',
  templateUrl: './new-utilisteur.component.html',
  styleUrls: ['./new-utilisteur.component.css']
})
export class NewUtilisteurComponent {

  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,){}

    cancel(): void {
      this.router.navigate(['utilisateur']);
    }

}
