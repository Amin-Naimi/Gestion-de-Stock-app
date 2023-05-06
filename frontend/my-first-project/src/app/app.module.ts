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
    FournisseursComponent
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
