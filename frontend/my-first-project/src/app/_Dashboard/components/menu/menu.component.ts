import { Component } from '@angular/core';
import { Menu } from './menu';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent {

  public menuProperties : Array<Menu> =[
   {
    id: '1',
    icone:'',
    titre:'Tableau de bord',
    url: '',
    sousMenus:[
      {
        id: '1.1',
        icone:"",
        titre:"Vue d'ensembele",
        url: '',
      },
      {
        id: '1.2',
        icone:"",
        titre:"Statistique",
        url: '',
      }

    ]
  },
  {
    id: '2',
    icone:'',
    titre:'Article',
    url: '',
    sousMenus:[
      {
        id: '2.1',
        icone:"",
        titre:"Articles",
        url: '',
      },
      {
        id: '2.2',
        icone:"",
        titre:"Mouvements de stock",
        url: '',
      }

    ]
  },
  {
    id: '3',
    icone:'',
    titre:'Clients',
    url: '',
    sousMenus:[
      {
        id: '3.1',
        icone:"",
        titre:"Clients",
        url: '',
      },
      {
        id: '3.2',
        icone:"",
        titre:"Commandes clients",
        url: '',
      }

    ]
  },
  {
    id: '4',
    icone:'',
    titre:'Fournisseurs',
    url: '',
    sousMenus:[
      {
        id: '4.1',
        icone:"",
        titre:"Fournisseurs",
        url: '',
      },
      {
        id: '4.2',
        icone:"",
        titre:"Commandes Fournisseurs",
        url: '',
      }

    ]
  },
  {
    id: '5',
    icone:'',
    titre:'Pramétrage',
    url: '',
    sousMenus:[
      {
        id: '5.1',
        icone:"",
        titre:"Categories",
        url: '',
      },
      {
        id: '5.2',
        icone:"",
        titre:"Utilisateurs",
        url: '',
      }

    ]
  },

  ]

}
