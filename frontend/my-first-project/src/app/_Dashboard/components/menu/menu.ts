export interface Menu{
  id?: string;
  titre?: string;
  icone?: string;
  url?: string;
  active?: boolean;
  sousMenus?: Array<Menu>;
}
