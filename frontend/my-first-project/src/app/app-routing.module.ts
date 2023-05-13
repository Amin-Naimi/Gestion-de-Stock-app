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
import { NewCmdCltFrsComponent } from './_Dashboard/components/new-cmd-clt-frs/new-cmd-clt-frs.component';
import { CategoriesComponent } from './_Dashboard/_Pages/categories/categories/categories.component';
import { NewCategoriesComponent } from './_Dashboard/_Pages/categories/new-categories/new-categories.component';
import { UtilisateursComponent } from './_Dashboard/_Pages/utilisateurs/utilisateurs/utilisateurs.component';
import { NewUtilisteurComponent } from './_Dashboard/_Pages/utilisateurs/new-utilisteur/new-utilisteur.component';
import { ProfileComponent } from './_Dashboard/_Pages/profile/profile/profile.component';
import { ChangerMotDepasseComponent } from './_Dashboard/_Pages/profile/changer-mot-depasse/changer-mot-depasse.component';
import { ApplicationGuard } from './auth/application.guard';


const routes: Routes = [

  { path: "login", component: LoginComponent },
  { path: "inscrire", component: InscireComponent },

  {
    path: '', component: DashboardComponent,
    canActivate: [ApplicationGuard],

    children: [
      {
        path: 'statistique', component: StatistiqueComponent,
      },

      {
        path: "articles", component: ArticlesComponent,

      },
      { path: "newarticles", component: NewArticleComponent },

      { path: "newarticles/:idarticle", component: NewArticleComponent },

      { path: "mvtstk", component: MvtStkComponent },
      { path: "client", component: ClientsComponent },
      { path: "fournisseurs", component: FournisseursComponent },

      {
        path: "newclient", component: NewCltFrsComponent,
        data: {
          origin: 'client'
        }
      },
      {
        path: "newfournisseur", component: NewCltFrsComponent,
        data: {
          origin: 'forunisseur'
        }
      },

      {
        path: "commandeclient", component: PageCmdCltFrsComponent,
        data: {
          origin: 'client'
        }
      },

      {
        path: "commandefournissuer", component: PageCmdCltFrsComponent,
        data: {
          origin: 'forunisseur'
        },
      },

      {
        path: "newcommandeclient", component: NewCmdCltFrsComponent,
        data: {
          origin: 'client'
        }
      },

      {
        path: "newcommandefournisseur", component: NewCmdCltFrsComponent,
        data: {
          origin: 'forunisseur'
        }
      },
      { path: "categories", component: CategoriesComponent },
      {
        path: "newcategorie", component: NewCategoriesComponent,
        data: {
          origin: 'creationCategory'
        }
      },

      {
        path: "newcategorie/:idcategory", component: NewCategoriesComponent,
        data: {
          origin: 'updateCategory'
        }
      },

      { path: "utilisateur", component: UtilisateursComponent },
      { path: "newutilisateur", component: NewUtilisteurComponent },
      { path: "profile", component: ProfileComponent },
      { path: "changermotdepasse", component: ChangerMotDepasseComponent },

    ]
  },

];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
