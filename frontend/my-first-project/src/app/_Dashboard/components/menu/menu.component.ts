import { Component, OnInit } from '@angular/core';
import { Menu } from './menu';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  public menuProperties: Array<Menu> = [
    {
    id: '1',
    titre: 'Tableau de bord',
    icone: 'fas fa-chart-line',
    url: '',
    sousMenus: [
      {
        id: '1.1',
        titre: 'Vue d\'ensemble',
        icone: 'fas fa-chart-pie',
        url: ''
      },
      {
        id: '1.2',
        titre: 'Statistiques',
        icone: 'fas fa-chart-bar',
        url: 'statistique'
      }
    ]
  },
    {
      id: '2',
      titre: 'Articles',
      icone: 'fas fa-boxes',
      url: 'articles',
      sousMenus: [
        {
          id: '2.1',
          titre: 'Articles',
          icone: 'fas fa-boxes',
          url: 'articles'
        },
        {
          id: '2.2',
          titre: 'Mouvements du stock',
          icone: 'fab fa-stack-overflow',
          url: 'mvtstk'
        }
      ]
    },
    {
      id: '3',
      titre: 'Clients',
      icone: 'fas fa-users',
      url: '',
      sousMenus: [
        {
          id: '3.1',
          titre: 'Clients',
          icone: 'fas fa-users',
          url: 'client'
        },
        {
          id: '3.2',
          titre: 'Commandes clients',
          icone: 'fas fa-shopping-basket',
          url: 'commandeclient'
        }
      ]
    },
    {
      id: '4',
      titre: 'Fournisseurs',
      icone: 'fas fa-users',
      url: 'fournisseurs',
      sousMenus: [
        {
          id: '4.1',
          titre: 'Fournisseurs',
          icone: 'fas fa-users',
          url: 'fournisseurs'
        },
        {
          id: '4.2',
          titre: 'Commandes fournisseurs',
          icone: 'fas fa-truck',
          url: 'commandefournissuer'
        }
      ]
    },
    {
      id: '5',
      titre: 'Parametrages',
      icone: 'fas fa-cogs',
      url: '',
      sousMenus: [
        {
          id: '5.1',
          titre: 'Categories',
          icone: 'fas fa-tools',
          url: 'categories'
        },
        {
          id: '5.2',
          titre: 'Utilisateurs',
          icone: 'fas fa-users-cog',
          url: 'utilisateur'
        }
      ]
    }
  ];

  private lastSelectedMenu: Menu | undefined;
  constructor(
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  navigate(menu: Menu): void {
    if (this.lastSelectedMenu) {
      this.lastSelectedMenu.active = false;
    }
    menu.active = true;
    this.lastSelectedMenu = menu;
    this.router.navigate([menu.url]);
  }

}
