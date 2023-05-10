import { Article } from "./Article";
import { Ventes } from "./Ventes";

export interface LigneVente {
  id?: number;
  ventes?: Ventes;
  article?: Article;
  quantite?: number;
  prixUnitaire?: number;
  idEntreprise?: number;
}
