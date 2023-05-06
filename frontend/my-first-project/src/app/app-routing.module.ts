import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { InscireComponent } from './inscire/inscire.component';
import { DashboardComponent } from './_Dashboard/dashboard/dashboard.component';
import { StatistiqueComponent } from './_Dashboard/statistique/statistique.component';
import { ArticlesComponent } from './_Dashboard/_Pages/articles/articles.component';
import { NewArticleComponent } from './_Dashboard/_Pages/articles/new-article/new-article.component';
import { MvtStkComponent } from './_Dashboard/_Pages/MovmentDeStocke/mvt-stk/mvt-stk.component';
import { ClientsComponent } from './_Dashboard/_Pages/clients/clients/clients.component';
import { FournisseursComponent } from './_Dashboard/_Pages/fournisseurs/fournisseurs/fournisseurs.component';


const routes: Routes = [

  { path: "login", component: LoginComponent },
  { path: "inscrire", component: InscireComponent },

  {
    path: "", component: DashboardComponent,
    children: [
      { path: 'statistique', component: StatistiqueComponent },
      { path: "articles", component: ArticlesComponent},
      { path: "newarticles", component: NewArticleComponent},
      { path: "mvtstk", component: MvtStkComponent},
      { path: "client", component: ClientsComponent},
      { path: "fournisseurs", component: FournisseursComponent},



    ]
  },

];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
