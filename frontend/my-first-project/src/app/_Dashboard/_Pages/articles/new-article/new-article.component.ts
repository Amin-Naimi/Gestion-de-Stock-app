import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Article } from 'src/app/Models/Article';
import { Category } from 'src/app/Models/Category';
import { ArticleService } from 'src/app/services/article.service';
import { CategoryService } from 'src/app/services/category.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-new-article',
  templateUrl: './new-article.component.html',
  styleUrls: ['./new-article.component.css']
})
export class NewArticleComponent implements OnInit {

  article: Article = {};
  listeArticles: Article[] = [];
  category: Category = {};
  listeCategorys: Category[] = [];
  errorMsg: Array<string> = [];

  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private articleService: ArticleService,
    private categoryService: CategoryService,
    private userService : UserService) { }

  ngOnInit(): void {
    this.findAllCategories();
  }

  findAllCategories(): void {
    this.categoryService.findAll()
      .subscribe((responce: Category[]) => {
        this.listeCategorys = responce;
      }, (error: any) => {
        console.log(error);
      });
  }

  enregistrerArticle(): void {
    console.log("Category identifiant : " + this.category.id);
    console.log(this.article.codeArticle);
    console.log(this.article.designation);
    console.log(this.article.prixUnitaire);
    console.log(this.article.prixUnitaireTTc);
    console.log(this.article.tauxTva);
    this.article.category = this.category;
    console.log("Mon category : "+this.category);


    this.articleService.enregisterArticle(this.article).subscribe(
      (responce : Article)=>{
        console.log(responce);
        this.router.navigate(['articles']);
      },
      (error: any) => {
        this.errorMsg = error.error.errors;
        console.log(this.errorMsg);

      }
    )

  }

  cancel(): void {
    this.router.navigate(['articles']);
  }


}
