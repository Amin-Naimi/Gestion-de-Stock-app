import { AdresseDto } from "./AdresseDto";

export interface EntrepriseDto {
  id?: number;
  nom?: string;
  description?: string;
  adresse?: AdresseDto;
  codefiscale?: string;
  photo?: string;
  email?: string;
  numTel?: string;
  siteWeb?: string;
}
