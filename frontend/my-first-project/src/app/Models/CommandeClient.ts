import { Client } from "./Client";
import { LigneCommandeClient } from "./LigneCommandeClient";

export interface CommandeClient {
  id?: number;
  code?: string;
  dateComande?: number;
  etatCommande?: 'EN_PREPARATION' | 'VALIDEE' | 'LIVREE';
  client?: Client;
  idEntreprise?: number;
  ligneComandeClientList?: Array<LigneCommandeClient>;
  commandeLivree?: boolean;
}
