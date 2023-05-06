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
import { NewCltFrsComponent } from './_Dashboard/components/new-clt-frs/new-clt-frs.component';
import { PageCmdCltFrsComponent } from './_Dashboard/_Pages/comande/page-cmd-clt-frs/page-cmd-clt-frs.component';


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
      { path: "newclient", component: NewCltFrsComponent},
      { path: "newfournisseur", component: NewCltFrsComponent},
      { path: "commandeclient", component: PageCmdCltFrsComponent},
      { path: "commandefournissuer", component: PageCmdCltFrsComponent},






    ]
  },

];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
