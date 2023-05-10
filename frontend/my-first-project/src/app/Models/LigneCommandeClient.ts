import { Article } from "./Article";
import { CommandeClient } from "./CommandeClient";

export interface LigneCommandeClient {
  id?: number;
  creationDate?: number;
  lastModifiedDate?: number;
  article?: Article;
  commandeClient?: CommandeClient;
  quantite?: number;
  prixUnitaire?: number;
  idEntreprise?: number;
}
