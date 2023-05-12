import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from 'src/app/Models/Category';
import { CategoryService } from 'src/app/services/category.service';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {

  listCategory: Category[] = [];
  selectedCategoryId! : number;
  categoryName = "";
  errorMsg  = "";

  constructor(private router: Router,
    private categoryService: CategoryService) { }

  ngOnInit(): void {
    this.findAllCategories();
  }

  findAllCategories(): void {
    this.categoryService.findAll()
      .subscribe((res : Category[]) => {
        this.listCategory = res;
      },(error : any)=>{
        console.log(error);
      });
  }

  nouvelleCategorie():void{
    this.router.navigate(['newcategorie']);
  }

  modifierCategory(id?: number): void {
    this.router.navigate(['newcategorie', id]);
  }

  confirmerEtSupprimer():void{
    if(this.selectedCategoryId)
    {
      console.log("Id category à supprimer : "+ this.selectedCategoryId)
      this.categoryService.deleteCategory(this.selectedCategoryId).subscribe(
        (responce :any)=>{
          this.router.navigate(['categories']);
          this.findAllCategories();
        },
        (error : any)=>{
          this.errorMsg = error.error.message;
          console.log(this.errorMsg);
        })
    }

  }
  selectedCategory(idCategory : number , categoryDesignation : string):void{
    this.selectedCategoryId = idCategory;
    this.categoryName = categoryDesignation;

  }


}
