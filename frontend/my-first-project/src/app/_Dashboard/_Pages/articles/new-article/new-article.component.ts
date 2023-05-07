import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-new-article',
  templateUrl: './new-article.component.html',
  styleUrls: ['./new-article.component.css']
})
export class NewArticleComponent {

  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,){}

    cancel(): void {
      this.router.navigate(['articles']);
    }


}
