import { AdresseDto } from "./AdresseDto";
import { CommandeFournisseur } from "./CommandeFournisseur";

export interface Fournisseur {
  id?: number;
  nom?: string;
  prenom?: string;
  adresse?: AdresseDto;
  photo?: string;
  mail?: string;
  numTel?: string;
  idEntreprise?: number;
}
