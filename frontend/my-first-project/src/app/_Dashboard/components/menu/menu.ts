export interface Menu{
  id?: string;
  titre?: string;
  icone?: string;
  url?: string;
  sousMenus?: Array<Menu>;
}
