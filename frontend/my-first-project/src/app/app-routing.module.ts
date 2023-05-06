import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { InscireComponent } from './inscire/inscire.component';
import { DashboardComponent } from './_Dashboard/dashboard/dashboard.component';
import { StatistiqueComponent } from './_Dashboard/statistique/statistique.component';
import { ArticlesComponent } from './_Dashboard/_Pages/articles/articles.component';


const routes: Routes = [

  { path: "login", component: LoginComponent },
  { path: "inscrire", component: InscireComponent },

  {
    path: "", component: DashboardComponent,
    children: [
      { path: 'statistique', component: StatistiqueComponent },
      { path: "articles", component: ArticlesComponent}
    ]
  },

];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
