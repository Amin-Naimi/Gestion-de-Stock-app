import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Category } from 'src/app/Models/Category';
import { CategoryService } from 'src/app/services/category.service';

@Component({
  selector: 'app-new-categories',
  templateUrl: './new-categories.component.html',
  styleUrls: ['./new-categories.component.css']
})
export class NewCategoriesComponent implements OnInit {

  category: Category = {};
  errorMsg: Array<string> = [];
  idCategory : number = 0;
  origin :string = '';
  operationType : string ="";



  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private categoryService: CategoryService) { }

  ngOnInit(): void {
    this.activatedRoute.data.subscribe((data :any) => {
      this.origin = data.origin;
    })
    console.log("origin de route: " + this.origin);
     this.idCategory = this.activatedRoute.snapshot.params['idcategory'];
    if(this.idCategory){
      this.categoryService.findById(this.idCategory).subscribe((response : Category)=>{
        this.category = response;
      },
      (error : any)=>{
        console.log(error);
      }
      )
    }
  }

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

  updateCategory(): void {
   /* console.log("id Category " + this.idCategory);
    console.log("code category" + this.category.codeCategory);
    console.log("Category designation" + this.category.designation);*/
    this.categoryService.updateCategory(this.idCategory,this.category).subscribe(
      (responce: Category) => {
        this.router.navigate(['categories']);
      },
      (error: any) => {
        this.errorMsg = error.error.errors;
      }
    )
  }

  clickedButton():void{
    if(this.origin === "creationCategory"){
      console.log("Opération de création")
      this.enregistrerCategory();
    }
    else if (this.origin === "updateCategory"){
      console.log("Opération de mise à jour")
      this.updateCategory();
    }
  }
}
