import { Article } from "./Article";
import { CommandeClient } from "./CommandeClient";

export interface LigneCommandeClient {
  id?: number;
  article?: Article;
  quantite?: number;
  prixUnitaire?: number;
  idEntreprise?: number;
}
