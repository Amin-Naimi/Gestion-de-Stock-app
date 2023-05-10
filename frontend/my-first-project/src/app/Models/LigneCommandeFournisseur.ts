import { Article } from "./Article";
import { CommandeFournisseur } from "./CommandeFournisseur";

export interface LigneCommandeFournisseur {
  id?: number;
  creationDate?: number;
  lastModifiedDate?: number;
  article?: Article;
  commandeFournisseur?: CommandeFournisseur;
  quantite?: number;
  prixUnitaire?: number;
  idEntreprise?: number;
}
