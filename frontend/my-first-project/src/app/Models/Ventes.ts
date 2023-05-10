import { LigneVente } from "./LigneVente";

export interface Ventes {
  id?: number;
  code?: string;
  dateVente?: number;
  commentaire?: string;
  ligneVentes?: Array<LigneVente>;
  idEntreprise?: number;
}
