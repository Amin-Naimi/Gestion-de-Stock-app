import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Article } from 'src/app/Models/Article';
import { ArticleService } from 'src/app/services/article.service';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.css']
})
export class ArticlesComponent implements OnInit {

  articlesList  : Article[] = [];

  constructor(private router: Router,
   private articleService: ArticleService){}

   ngOnInit(): void {
    this.findAllArticle();
  }

  nouvelArticle(): void {
    this.router.navigate(['newarticles']);
  }

  findAllArticle():void{
    this.articleService.getAllArticles().subscribe(
      (responce : Article[])=>{
        console.log(responce);
        this.articlesList = responce;
      },
      (error : any)=>{
        console.log(error);
      }
    )
  }

}
