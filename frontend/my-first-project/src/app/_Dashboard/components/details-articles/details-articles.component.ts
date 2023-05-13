import { Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';
import { Article } from 'src/app/Models/Article';
import { ArticleService } from 'src/app/services/article.service';

@Component({
  selector: 'app-details-articles',
  templateUrl: './details-articles.component.html',
  styleUrls: ['./details-articles.component.css']
})
export class DetailsArticlesComponent implements OnInit {

  @Input()
  article: Article = {};

  @Input()
  articleName :string = "";

  @Output()
  suppressionResult = new EventEmitter();


  constructor(private articleService: ArticleService,
    private router: Router,
  ) { }


  ngOnInit(): void {
  }

  modifierArticle(): void {
    this.router.navigate(['newarticles', this.article.id]);
  }
  confirmerEtSupprimerArticle(): void{
      if (this.article.id) {
        console.log("article id : " + this.article.id);
        this.articleService.deleteArticle(this.article.id)
        .subscribe((responce : any) => {
          console.log(responce)
          this.suppressionResult.emit('success');
        }, (error : any) => {
          console.log(error)
        });
    }

  }

  teste():void{
    console.log(this.articleName);
  }


}
