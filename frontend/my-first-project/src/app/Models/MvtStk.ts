import { Article } from "./Article";

export interface MvtStk {

  id?: number;
  dateMvt?: number;
  quantite?: number;
  article?: Article;
  typeMvt?: 'ENTREE' | 'SORTIE' | 'CORRECTION_POS' | 'CORRECTION_NEG';
  sourceMvt?: 'COMMANDE_CLIENT' | 'COMMANDE_FOURNISSEUR' | 'VENTE';
  idEntreprise?: number;
}
