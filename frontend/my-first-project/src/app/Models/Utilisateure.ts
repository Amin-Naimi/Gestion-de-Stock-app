import { AdresseDto } from "./AdresseDto";
import { EntrepriseDto } from "./EntrepriseDto";
import { Roles } from "./Roles";

export interface Utilisateur{
  id?: number;
  nom?: string;
  prenom?: string;
  email?: string;
  dateDeNaissance?: number;
  motDePasse?: string;
  adresse?: AdresseDto;
  photo?: string;
  entreprise?: EntrepriseDto;
  roles?: Array<Roles>;
}
