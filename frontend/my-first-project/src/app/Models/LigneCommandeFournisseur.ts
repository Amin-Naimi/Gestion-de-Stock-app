import { Article } from "./Article";
import { CommandeFournisseur } from "./CommandeFournisseur";

export interface LigneCommandeFournisseur {
  id?: number;
  article?: Article;
  commandeFournisseur?: CommandeFournisseur;
  quantite?: number;
  prixUnitaire?: number;
  idEntreprise?: number;
}
