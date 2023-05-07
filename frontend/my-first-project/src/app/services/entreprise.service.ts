import { Injectable } from '@angular/core';
import { EnServiceService } from './en-service.service';
import { EntrepriseDto } from '../Models/EntrepriseDto';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EntrepriseService {

  constructor(
    private enService: EnServiceService
  ) { }

  sinscrire(entreprise: EntrepriseDto): Observable<EntrepriseDto> {
    return this.enService.save(entreprise);
  }
}
