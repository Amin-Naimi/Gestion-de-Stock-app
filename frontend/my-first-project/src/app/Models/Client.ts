import { AdresseDto } from "./AdresseDto";
import { CommandeClient } from "./CommandeClient";

export interface Client {
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
  commandeClients?: Array<CommandeClient>;
}
