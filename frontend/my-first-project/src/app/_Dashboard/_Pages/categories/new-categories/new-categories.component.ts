import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-new-categories',
  templateUrl: './new-categories.component.html',
  styleUrls: ['./new-categories.component.css']
})
export class NewCategoriesComponent {

  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,){}

    cancel(): void {
      this.router.navigate(['/categories']);
    }

}
