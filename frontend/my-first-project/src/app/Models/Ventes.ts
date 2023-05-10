import { LigneVente } from "./LigneVente";

export interface Ventes {
  id?: number;
  creationDate?: number;
  lastModifiedDate?: number;
  code?: string;
  dateVente?: number;
  commentaire?: string;
  idEntreprise?: number;
  ligneVentes?: Array<LigneVente>;
}
