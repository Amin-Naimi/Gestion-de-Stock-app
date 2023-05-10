import { AdresseDto } from "./AdresseDto";
import { CommandeFournisseur } from "./CommandeFournisseur";

export interface Fournisseur {
  id?: number;
  creationDate?: number;
  lastModifiedDate?: number;
  nom?: string;
  prenom?: string;
  adresse?: AdresseDto;
  photo?: string;
  mail?: string;
  numTel?: string;
  idEntreprise?: number;
  commandeFournisseurs?: Array<CommandeFournisseur>;
}
