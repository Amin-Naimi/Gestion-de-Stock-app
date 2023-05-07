import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-changer-mot-depasse',
  templateUrl: './changer-mot-depasse.component.html',
  styleUrls: ['./changer-mot-depasse.component.css']
})
export class ChangerMotDepasseComponent {

  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,){}

    cancel(): void {
      this.router.navigate(['/profile']);
    }

}
