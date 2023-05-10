import { Article } from "./Article";
import { Ventes } from "./Ventes";

export interface LigneVente {
  id?: number;
  creationDate?: number;
  lastModifiedDate?: number;
  vente?: Ventes;
  article?: Article;
  quantite?: number;
  prixUnitaire?: number;
  idEntreprise?: number;
}
