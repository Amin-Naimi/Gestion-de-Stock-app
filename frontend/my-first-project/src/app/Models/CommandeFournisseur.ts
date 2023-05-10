import { Fournisseur } from "./Fournisseur";
import { LigneCommandeFournisseur } from "./LigneCommandeFournisseur";

export interface CommandeFournisseur {
  id?: number;
  code?: string;
  dateComande?: number;
  etatCommande?: 'EN_PREPARATION' | 'VALIDEE' | 'LIVREE';
  fournisseur?: Fournisseur;
  idEntreprise?: number;
  ligneComandeFournisseurList?: Array<LigneCommandeFournisseur>;
  commandeLivree?: boolean;
}
