import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
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

}
