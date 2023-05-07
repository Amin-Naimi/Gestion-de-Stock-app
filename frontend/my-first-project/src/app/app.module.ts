import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './home/home.component';
import { FormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { InscireComponent } from './inscire/inscire.component';
import { DashboardComponent } from './_Dashboard/dashboard/dashboard.component';
import { StatistiqueComponent } from './_Dashboard/statistique/statistique.component';
import { MenuComponent } from './_Dashboard/components/menu/menu.component';
import { HeaderComponent } from './_Dashboard/components/header/header.component';
import { ArticlesComponent } from './_Dashboard/_Pages/articles/articles.component';
import { DetailsArticlesComponent } from './_Dashboard/components/details-articles/details-articles.component';
import { PaginationComponent } from './_Dashboard/components/pagination/pagination.component';
import { ButtonActionComponent } from './_Dashboard/components/button-action/button-action.component';
import { NewArticleComponent } from './_Dashboard/_Pages/articles/new-article/new-article.component';
import { MvtStkComponent } from './_Dashboard/_Pages/MovmentDeStocke/mvt-stk/mvt-stk.component';
import { DetailsMvtstkArticlesComponent } from './_Dashboard/components/details-mvtstk-articles/details-mvtstk-articles.component';
import { DetailsMvtstkComponent } from './_Dashboard/components/details-mvtstk/details-mvtstk.component';
import { DetailsClFrsComponent } from './_Dashboard/components/details-cl-frs/details-cl-frs.component';
import { ClientsComponent } from './_Dashboard/_Pages/clients/clients/clients.component';
import { FournisseursComponent } from './_Dashboard/_Pages/fournisseurs/fournisseurs/fournisseurs.component';
import { NewCltFrsComponent } from './_Dashboard/components/new-clt-frs/new-clt-frs.component';
import { DetailsCmdCltFrsComponent } from './_Dashboard/components/details-cmd-clt-frs/details-cmd-clt-frs.component';
import { DetailsCmdComponent } from './_Dashboard/components/details-cmd/details-cmd.component';
import { PageCmdCltFrsComponent } from './_Dashboard/_Pages/comande/page-cmd-clt-frs/page-cmd-clt-frs.component';
import { NewCmdCltFrsComponent } from './_Dashboard/components/new-cmd-clt-frs/new-cmd-clt-frs.component';
import { CategoriesComponent } from './_Dashboard/_Pages/categories/categories/categories.component';
import { NewCategoriesComponent } from './_Dashboard/_Pages/categories/new-categories/new-categories.component';
import { UtilisateursComponent } from './_Dashboard/_Pages/utilisateurs/utilisateurs/utilisateurs.component';
import { NewUtilisteurComponent } from './_Dashboard/_Pages/utilisateurs/new-utilisteur/new-utilisteur.component';
import { DetailUtilisateurComponent } from './_Dashboard/components/detail-utilisateur/detail-utilisateur.component';
import { ProfileComponent } from './_Dashboard/_Pages/profile/profile/profile.component';
import { ChangerMotDepasseComponent } from './_Dashboard/_Pages/profile/changer-mot-depasse/changer-mot-depasse.component';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    InscireComponent,
    DashboardComponent,
    StatistiqueComponent,
    MenuComponent,
    HeaderComponent,
    ArticlesComponent,
    DetailsArticlesComponent,
    PaginationComponent,
    ButtonActionComponent,
    NewArticleComponent,
    MvtStkComponent,
    DetailsMvtstkArticlesComponent,
    DetailsMvtstkComponent,
    DetailsClFrsComponent,
    ClientsComponent,
    FournisseursComponent,
    NewCltFrsComponent,
    DetailsCmdCltFrsComponent,
    DetailsCmdComponent,
    PageCmdCltFrsComponent,
    NewCmdCltFrsComponent,
    CategoriesComponent,
    NewCategoriesComponent,
    UtilisateursComponent,
    NewUtilisteurComponent,
    DetailUtilisateurComponent,
    ProfileComponent,
    ChangerMotDepasseComponent
  ],
  imports: [
    BrowserModule,
    NgbModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
