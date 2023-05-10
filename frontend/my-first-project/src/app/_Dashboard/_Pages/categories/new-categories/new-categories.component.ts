import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Category } from 'src/app/Models/Category';
import { CategoryService } from 'src/app/services/category.service';

@Component({
  selector: 'app-new-categories',
  templateUrl: './new-categories.component.html',
  styleUrls: ['./new-categories.component.css']
})
export class NewCategoriesComponent {

  category: Category = {};
  errorMsg: Array<string> = [];



  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private categoryService: CategoryService) { }

  cancel(): void {
    this.router.navigate(['/categories']);
  }

  enregistrerCategory(): void {
    this.categoryService.enregistrerCategory(this.category)
      .subscribe((responce: Category) => {
        this.router.navigate(['categories']);
      }, (error: any) => {
        this.errorMsg = error.error.errors;
      });
  }
}
