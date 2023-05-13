import { Category } from "./Category";
import { LigneCommandeClient } from "./LigneCommandeClient";
import { LigneCommandeFournisseur } from "./LigneCommandeFournisseur";
import { LigneVente } from "./LigneVente";
import { MvtStk } from "./MvtStk";

export interface Article {
  id?: number;
  codeArticle?: string;
  designation?: string;
  prixUnitaire?: number;
  tauxTva?: number;
  prixUnitaireTTc?: number;
  photo?: string;
  category?: Category;
  idEntreprise?: number;
}
