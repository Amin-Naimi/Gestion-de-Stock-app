import { Category } from "./Category";
import { LigneCommandeClient } from "./LigneCommandeClient";
import { LigneCommandeFournisseur } from "./LigneCommandeFournisseur";
import { LigneVente } from "./LigneVente";
import { MvtStk } from "./MvtStk";

export interface Article {
  id?: number;
  creationDate?: number;
  lastModifiedDate?: number;
  codeArticle?: string;
  designation?: string;
  prixUnitaireHt?: number;
  tauxTva?: number;
  prixUnitaireTtc?: number;
  photo?: string;
  idEntreprise?: number;
  category?: Category;
  ligneVentes?: Array<LigneVente>;
  ligneCommandeClients?: Array<LigneCommandeClient>;
  ligneCommandeFournisseurs?: Array<LigneCommandeFournisseur>;
  mvtStks?: Array<MvtStk>;
}
